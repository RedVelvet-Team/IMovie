package com.redvelvet.repository.repository

import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.entities.auth.Token
import com.redvelvet.repository.mapper.toGuest
import com.redvelvet.repository.mapper.toSession
import com.redvelvet.repository.mapper.toToken
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) : UserRepository, BaseRepository() {
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
    override suspend fun createGuestSession(): Guest {
        return wrapRemoteResponse {
            remoteDataSource.createGuestSession().toGuest()
        }
    }

    override suspend fun createToken(): Token {
        return wrapRemoteResponse {
            remoteDataSource.createToken().toToken()
        }
    }

    override suspend fun validateUserWithLogin(userName: String, password: String): Token {
        return wrapRemoteResponse {
            remoteDataSource.validateUserWithLogin(
                userName = userName,
                password = password
            ).toToken()
        }
    }

    override suspend fun createUserSession(): Session {
        return wrapRemoteResponse {
            remoteDataSource.createUserSession().toSession()
        }
    }

    override suspend fun deleteUserSession(): Session {
        return wrapRemoteResponse {
            remoteDataSource.deleteUserSession().toSession()
        }
    }
}
