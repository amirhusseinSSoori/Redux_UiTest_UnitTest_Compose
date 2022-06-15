package com.amirhusseinsoori.data.di

import com.amirhusseinsoori.data.network.response.Details
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Cbor
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object KtorModule {


    @Provides
    @Singleton
    fun provideClientService(): HttpClient {
        return HttpClient(Android) {
            // Logging
            install(Logging) {
                level = LogLevel.ALL
            }
            // JSON
            install(ContentNegotiation) {
                json(Json {
                    var prettyPrint = true
                    isLenient = true
                    serializersModule = SerializersModule {
                       contextual(Details.serializer().withJsonFormat(Json { ignoreUnknownKeys = true }))

                    }
                })
            }
            // Timeout
            install(HttpTimeout) {
                requestTimeoutMillis = 15000L
                connectTimeoutMillis = 15000L
                socketTimeoutMillis = 15000L
            }
            // Apply to all requests
            defaultRequest {
                // Parameter("api_key", "some_api_key")
                // Content Type
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
    }


}

fun <T> KSerializer<T>.withJsonFormat(json: Json) : KSerializer<T> = object : KSerializer<T> by this {
    override fun deserialize(decoder: Decoder): T {
        // Cast to JSON-specific interface
        val jsonInput = decoder as? JsonDecoder ?: error("Can be deserialized only by JSON")
        // Read the whole content as JSON
        val originalJson = jsonInput.decodeJsonElement().jsonObject
        return json.decodeFromJsonElement(this@withJsonFormat, originalJson)
    }
}