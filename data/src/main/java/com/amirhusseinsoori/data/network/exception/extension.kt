package com.amirhusseinsoori.data.exception

inline fun <R, T> CustomResult<T>.fold(
    onSuccess: (value: T) -> R,
    onLoading: (loading: LoadingOccurs) -> R,
    onFailure: (exception: Throwable) -> R
): R {
    onLoading(LoadingOccurs.StartLoading)
    return when (val exception = exceptionOrNull()) {
        null -> {
            onLoading(LoadingOccurs.FinishLoading)
            onSuccess(value as T)
        }
        else -> {
            onLoading(LoadingOccurs.FinishLoading)
            onFailure(exception)

        }
    }
}