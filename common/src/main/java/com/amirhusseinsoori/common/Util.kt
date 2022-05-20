package com.amirhusseinsoori.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

suspend inline fun <T> Flow<Result<T>>.eventHandle(
    crossinline result: suspend (T) -> Unit,
    crossinline onError: suspend (String) -> Unit,
    crossinline isLoading: suspend (Boolean) -> Unit
) {
    onStart {
        isLoading(true)
    }.onCompletion {
        isLoading(false)
    }.collect() { data ->
        data.fold(onSuccess = { data ->
            result(data)
        }, onFailure = { error ->
            onError(error.message ?: "")
        })
    }
}