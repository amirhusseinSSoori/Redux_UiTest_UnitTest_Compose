package com.amirhusseinsoori.data.network.interceptor

import com.amirhusseinsoori.common.Constant.apiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()
        val newResponse = chain.request().newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newResponse)
    }
}