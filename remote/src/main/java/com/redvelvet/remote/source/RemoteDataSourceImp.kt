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
            val responseBody = response.body() ?: throw RemoteError.NullData
            if (response.isSuccessful) {
                return responseBody.value ?: throw RemoteError.NullData
            } else {
                throw remoteErrorMap[responseBody.code ?: 0]!!
            }
        }catch (e: Exception){
            throw RemoteError.Network
        }
    }

   private companion object RemoteErrorMap{
       private val remoteErrorMap = mapOf(
           3 to RemoteError.AuthenticationFailed,
           7 to RemoteError.InvalidApiKey,
           9 to RemoteError.ServiceOffline,
           10 to RemoteError.SuspendedApiKey,
           11 to RemoteError.InternalError,
           14 to RemoteError.AuthenticationFailed2,
           15 to RemoteError.Failed,
           16 to RemoteError.DeviceDenied,
           17 to RemoteError.SessionDenied,
           24 to RemoteError.BackendTimeout,
           26 to RemoteError.UsernamePasswordRequired,
           30 to RemoteError.InvalidUsernamePassword,
           31 to RemoteError.AccountDisabled,
           32 to RemoteError.EmailNotVerified,
           33 to RemoteError.InvalidRequestToken,
           35 to RemoteError.InvalidToken,
           36 to RemoteError.InsufficientPermissions,
           39 to RemoteError.ResourcePrivate,
           43 to RemoteError.ConnectionError,
           44 to RemoteError.InvalidId,
           46 to RemoteError.MaintenanceMode,
           47 to RemoteError.InvalidInput
       ).withDefault { RemoteError.InternalError }
   }
}