package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.data.BuildConfig.DEBUG
import com.amirhusseinsoori.data.network.interceptor.AuthInterceptor
import com.amirhusseinsoori.data.network.interceptor.ResponseFormatterInterceptor
import com.amirhusseinsoori.data.network.response.Details
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object KtorModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level =
            if (DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return loggingInterceptor
    }

    @Provides
    fun provideOkHttp(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor,
        responseFormatter: ResponseFormatterInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(responseFormatter)
            .readTimeout(500, TimeUnit.SECONDS)
            .writeTimeout(500, TimeUnit.SECONDS)
            .connectTimeout(10000, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideClientService(
        okHttpClient: OkHttpClient,
    ): HttpClient {
        return HttpClient(OkHttp) {
            // Logging
            install(Logging) {
                level = LogLevel.ALL
            }
            // JSON
            install(ContentNegotiation) {
                json(Json {
                    isLenient = true
                    serializersModule = SerializersModule {
                        contextual(
                            Details.serializer().withJsonFormat(Json { ignoreUnknownKeys = true })
                        )
                    }
                })
            }
            engine {
                // this: OkHttpConfig
                config {
                    // this: OkHttpClient.Builder
                    followRedirects(true)
                    // ...
                }
                preconfigured = okHttpClient
            }

            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            // Apply to all requests
            defaultRequest {

                // Content Type
                contentType(Json)
                accept(Json)
            }
        }
    }


}

fun <T> KSerializer<T>.withJsonFormat(json: Json): KSerializer<T> =
    object : KSerializer<T> by this {
        override fun deserialize(decoder: Decoder): T {
            // Cast to JSON-specific interface
            val jsonInput = decoder as? JsonDecoder ?: error("Can be deserialized only by JSON")
            // Read the whole content as JSON
            val originalJson = jsonInput.decodeJsonElement().jsonObject
            return json.decodeFromJsonElement(this@withJsonFormat, originalJson)
        }
    }