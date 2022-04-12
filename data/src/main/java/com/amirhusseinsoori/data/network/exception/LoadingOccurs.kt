package com.amirhusseinsoori.data.exception

sealed class LoadingOccurs {
    object StartLoading : LoadingOccurs()
    object FinishLoading : LoadingOccurs()
}
