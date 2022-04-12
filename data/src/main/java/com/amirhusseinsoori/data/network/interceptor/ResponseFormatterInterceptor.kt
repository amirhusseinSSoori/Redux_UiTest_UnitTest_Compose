package com.amirhusseinsoori.data.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONException
import org.json.JSONObject
import java.lang.Long
import java.nio.charset.Charset
import javax.inject.Inject

class ResponseFormatterInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        var response = chain.proceed(request)
        val responseBody = response.body
        if (responseBody != null) {
            val source = responseBody.source()
            val buffer = source.buffer
            source.request(Long.MAX_VALUE)
            val rawDate = buffer.clone().readString(Charset.forName("UTF-8"))
            val jsonObject: JSONObject
            try {
                jsonObject = JSONObject(rawDate)
                response = response.newBuilder()
                    .body(
                        jsonObject.get("results").toString()
                            .toResponseBody(responseBody.contentType())
                    )
                    .build()
            } catch (ignored: JSONException) {
            }

        }
        return response
    }
}