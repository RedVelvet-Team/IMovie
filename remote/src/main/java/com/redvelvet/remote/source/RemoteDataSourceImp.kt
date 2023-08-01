package com.redvelvet.remote.source

import com.redvelvet.remote.response.BaseResponse
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.remote.util.RemoteErrorMap.remoteErrorMap
import com.redvelvet.repository.RemoteError
import com.redvelvet.repository.source.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val movieApiService: MovieApiService
) : RemoteDataSource {
    private suspend fun <T> wrapResponse(
        function: suspend () -> Response<BaseResponse<T>>
    ): T {
        try {
            val response = function()
            val responseBody = response.body() ?: throw RemoteError.NullData
            if (response.isSuccessful) {
                return responseBody.results ?: throw RemoteError.NullData
            } else {
                throw remoteErrorMap[responseBody.code ?: 0]!!
            }
        } catch (e: Exception) {
            throw RemoteError.Network
        }
    }
}