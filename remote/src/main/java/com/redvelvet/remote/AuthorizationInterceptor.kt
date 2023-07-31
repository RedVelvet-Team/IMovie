package com.redvelvet.remote

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .url(buildUrl(request))
            .build()
        return chain.proceed(newRequest)
    }

    private fun buildUrl(request: Request): HttpUrl {
        return request.url.newBuilder()
            .addQueryParameter(API_KEY, BuildConfig.API_KEY)
            .build()
    }

    private companion object {
        private const val API_KEY = "api_key"
    }
}