package com.redvelvet.repository.repository

import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.entities.auth.Token
import com.redvelvet.repository.mapper.toGuest
import com.redvelvet.repository.mapper.toSession
import com.redvelvet.repository.mapper.toToken
import com.redvelvet.repository.source.DataStoreDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dataStoreDataSource: DataStoreDataSource,
) : BaseRepository(), AuthRepository {
    //region auth
    override suspend fun createGuestSession(): Guest {
        return wrapRemoteResponse {
            remoteDataSource.createGuestSession().toGuest()
        }
    }

    override suspend fun saveGuestSession(id: String, expDate: String) {
        dataStoreDataSource.setGuestSession(id, expDate)
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
    //endregion

    //region user
    override suspend fun setIsLoggedInByGuest(isLogged: Boolean) {
        dataStoreDataSource.setIsLoggedByGuest(isLogged)
    }

    override suspend fun setIsLoggedInByAccount(isLogged: Boolean) {
        dataStoreDataSource.setIsLoggedByAccount(isLogged)
    }
    //endregion
}