package com.redvelvet.repository.repository

import com.google.gson.Gson
import com.redvelvet.entities.user.Token
import com.redvelvet.repository.dto.ErrorResponseDto
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : UserRepository,BaseRepository() {
    override suspend fun setIsLoggedByAccount(isLogged: Boolean) {
        localDataSource.setIsLoggedByAccount(isLogged)
    }

    override suspend fun getIsLoggedByAccount() = localDataSource.getIsLoggedByAccount()

    override suspend fun setIsLoggedByGuest(isLogged: Boolean) {
        localDataSource.setIsLoggedByGuest(isLogged)
    }

    override suspend fun getIsLoggedByGuest() = localDataSource.getIsLoggedByGuest()
    override suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean) {
        localDataSource.setIsFirstTimeUsingApp(isFirstTime)
    }

    override suspend fun getIsFirstTimeUsingApp() = localDataSource.getIsFirstTimeUsingApp()
    override suspend fun getNewRequestToken(): Token {
        val response = remoteDataSource.getNewRequestToken()
        return if (response.isSuccessful) {
            Token(
                success = response.body()?.success,
                expiresAt = response.body()?.expiresAt,
                requestToken = response.body()?.requestToken,
            )
        } else {
            throw Exception(fromStringToErrorResponseDto(response.errorBody()?.string()!!))
        }
    }
}

private fun fromStringToErrorResponseDto(json: String): String {
    return Gson().fromJson(json, ErrorResponseDto::class.java).code.toString()
}
