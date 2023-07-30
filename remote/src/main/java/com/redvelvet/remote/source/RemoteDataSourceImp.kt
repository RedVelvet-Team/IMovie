package com.redvelvet.remote.source

import com.redvelvet.remote.response.ErrorResponse
import com.redvelvet.remote.service.MovieApiService
import com.redvelvet.repository.RemoteError
import com.redvelvet.repository.source.RemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(
    private val movieApiService: MovieApiService
) : RemoteDataSource {



    private suspend fun <T> wrapResponse(
        function: suspend () -> Response<ErrorResponse<T>>
    ): T {
        try {
            val response = function()
            val responseBody = response.body()?: throw RemoteError.NullData
            if (response.isSuccessful) {
                return responseBody.value ?: throw RemoteError.NullData
            } else {
                throw remoteErrorException(responseBody.code ?: 0)
            }
        }catch (e: Exception){
            throw RemoteError.Network
        }
    }

    private fun remoteErrorException(errorCode: Int) = when (errorCode) {
        3 -> RemoteError.AuthenticationFailed
        7 -> RemoteError.InvalidApiKey
        9 -> RemoteError.ServiceOffline
        10 -> RemoteError.SuspendedApiKey
        11 -> RemoteError.InternalError
        14 -> RemoteError.AuthenticationFailed2
        15 -> RemoteError.Failed
        16 -> RemoteError.DeviceDenied
        17 -> RemoteError.SessionDenied
        24 -> RemoteError.BackendTimeout
        26 -> RemoteError.UsernamePasswordRequired
        30 -> RemoteError.InvalidUsernamePassword
        31 -> RemoteError.AccountDisabled
        32 -> RemoteError.EmailNotVerified
        33 -> RemoteError.InvalidRequestToken
        35 -> RemoteError.InvalidToken
        36 -> RemoteError.InsufficientPermissions
        39 -> RemoteError.ResourcePrivate
        43 -> RemoteError.ConnectionError
        44 -> RemoteError.InvalidId
        46 -> RemoteError.MaintenanceMode
        47 -> RemoteError.InvalidInput
        else -> RemoteError.InternalError
    }
}