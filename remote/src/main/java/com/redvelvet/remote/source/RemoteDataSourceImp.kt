package com.redvelvet.remote.source

import android.util.Log
import com.google.gson.Gson
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.remote.util.RemoteErrorMap.remoteErrorMap
import com.redvelvet.repository.dto.ErrorResponseDto
import com.redvelvet.repository.dto.auth.request.LoginRequest
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.repository.util.RemoteError
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val movieApiService: MovieApiService
) : RemoteDataSource {

    override suspend fun createGuestSession(): GuestSessionDto {
        return wrapApiResponse {
            movieApiService.createGuestSession()
        }
    }

    override suspend fun createToken(): TokenDto {
        return wrapApiResponse {
            movieApiService.getNewRequestToken()
        }
    }

    override suspend fun validateUserWithLogin(userName: String, password: String): TokenDto {
        return wrapApiResponse {
            movieApiService.validateRequestTokenWithLogin(
                loginRequest = LoginRequest(
                    username = userName,
                    password = password,
                    requestToken = "7038d4ecc2a4954967a940d7e51884fce93cf7c0",
                )
            )
        }
    }


    private suspend fun <T> wrapApiResponse(
        request: suspend () -> Response<T>
    ): T {
        try {
            val response = request()
            if (response.isSuccessful) {
                return response.body() ?: throw RemoteError.NullData
            } else {
                throw remoteErrorMap[getErrorCodeFromJson(response.errorBody()?.string() ?: "")]!!
            }
        } catch (e: Exception) {
            Log.e("KAMELOO", e.message.toString())
            throw RemoteError.Network
        }
    }
}

private fun getErrorCodeFromJson(json: String): Int {
    return Gson().fromJson(json, ErrorResponseDto::class.java).code ?: 0
}