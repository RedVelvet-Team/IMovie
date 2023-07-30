package com.redvelvet.remote

import com.redvelvet.repository.source.LocalDataSource
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class AuthorizationInterceptor @Inject constructor(
    private val localDataSource: LocalDataSource
) : Interceptor {

    private val apiKey: String = BuildConfig.API_KEY

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .url(buildUrl(request))
            .build()

        return chain.proceed(newRequest)
    }

    private fun buildUrl(request: Request): HttpUrl {
        return request.url.newBuilder()
            .addQueryParameter(API_KEY, apiKey)
            .addQueryParameter(REQUEST_TOKEN, localDataSource.getToken())
            .addQueryParameter(SESSION_ID, localDataSource.getSessionId())
            .build()
    }

    companion object {
        const val API_KEY = "api_key"
        const val REQUEST_TOKEN = "request_token"
        const val SESSION_ID = "session_id"
    }
}