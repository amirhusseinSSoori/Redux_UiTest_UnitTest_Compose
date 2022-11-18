package com.amirhusseinsoori.data.repository

import arrow.core.Either
import com.amirhusseinsoori.domain.entity.Status

import io.ktor.client.call.*
import io.ktor.client.statement.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

open class BaseRepository() {
    inline fun <reified T> request(httpResponse: HttpResponse, message: String): Flow<Either<T, Status>> =
        flow {
            when (httpResponse.status.value) {
                in 200..299 -> {
                    emit(
                        Either.Left(
                            httpResponse.body<T>()
                        )
                    )
                }
                in 400..422 -> {
                    emit(
                        Either.Right(
                            Status(
                                code = httpResponse.status.value,
                                message = message
                            )
                        )
                    )
                }
            }
        }.catch { ex ->
            emit(
                Either.Right(
                    Status(
                        code = 500,
                        message = ex.message ?: ""
                    )
                )
            )
        }



}