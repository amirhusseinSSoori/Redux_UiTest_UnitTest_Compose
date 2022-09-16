package com.amirhusseinsoori.data

import com.amirhusseinsoori.code_challenge.data.di.NetworkModule.apiKey
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONException
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.charset.Charset

open class BaseTest {
    private lateinit var mockWebServer: MockWebServer

    lateinit var retrofit: Retrofit

    private lateinit var okHttpClient: OkHttpClient

    private lateinit var loggingInterceptor: HttpLoggingInterceptor
    private lateinit var authInterceptor: Interceptor
    private lateinit var responseFormatter: Interceptor

    @Before
    open fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.dispatcher = RequestDispatcher()
        mockWebServer.start()

        authInterceptor = Interceptor { chain ->
            val newUrl = chain.request().url
                .newBuilder()
                .addQueryParameter("api_key", apiKey)
                .build()

            val newResponse = chain.request().newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newResponse)
        }

        responseFormatter = Interceptor { chain ->
            val request = chain.request()
            var response = chain.proceed(request)
            val responseBody = response.body
            if (responseBody != null) {
                val source = responseBody.source()
                val buffer = source.buffer()
                source.request(Long.MAX_VALUE)
                val rawDate = buffer.clone().readString(Charset.forName("UTF-8"))
                val jsonObject: JSONObject
                try {
                    jsonObject = JSONObject(rawDate)
                    response = response.newBuilder()
                        .body(
                            ResponseBody.create(
                                responseBody.contentType(),
                                jsonObject.get("results").toString()
                            )
                        )
                        .build()
                } catch (ignored: JSONException) {
                }

            }
            response
        }

        loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        okHttpClient = buildOkhttpClient(loggingInterceptor)

        retrofit = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }

    fun <T> getApiService(apiServiceInterfaceClass: Class<T>): T {
        return retrofit.create(apiServiceInterfaceClass)
    }

    @After
    open fun tearDown() {
        mockWebServer.shutdown()
    }

    private fun buildOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .addInterceptor(responseFormatter)
            .build()
    }
}