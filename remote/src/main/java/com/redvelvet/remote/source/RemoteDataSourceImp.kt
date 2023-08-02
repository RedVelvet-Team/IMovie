package com.redvelvet.remote.source

import com.google.gson.Gson
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.remote.util.RemoteErrorMap.remoteErrorMap
import com.redvelvet.repository.dto.ErrorResponseDto
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
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
            throw RemoteError.Network
        }
    }
}

private fun getErrorCodeFromJson(json: String): Int {
    return Gson().fromJson(json, ErrorResponseDto::class.java).code ?: 0
}