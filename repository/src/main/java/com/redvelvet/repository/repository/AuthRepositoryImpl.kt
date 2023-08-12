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
            remoteDataSource.createGuestSession().toGuest().also { guest ->
                saveGuestSession(
                    id = guest.guestSessionId.toString(),
                    expDate = guest.expiresAt.toString()
                )
                setIsLoggedInByGuest(true)
            }
        }
    }

    private suspend fun saveGuestSession(id: String, expDate: String) {
        dataStoreDataSource.setGuestSession(id, expDate)
    }


    override suspend fun createToken(): Token {
        return wrapRemoteResponse {
            remoteDataSource.createToken().toToken()
        }
    }


    override suspend fun validateUserWithLogin(
        userName: String,
        password: String,
        requestToken: String,
    ): Token {
        return wrapRemoteResponse {
            remoteDataSource.validateUserWithLogin(
                userName = userName,
                password = password,
                requestToken = requestToken
            ).toToken()
        }
    }


    override suspend fun createUserSession(token: String): Session {
        return wrapRemoteResponse {
            remoteDataSource.createUserSession(token).toSession().also { session ->
                saveUserSessionId(session.sessionId.toString())
                setIsLoggedInByAccount(true)
                setIsLoggedInByGuest(false)
            }
        }
    }

    private suspend fun saveUserSessionId(id: String) {
        dataStoreDataSource.setUserSessionId(id = id)
    }


    override suspend fun deleteUserSession(sessionId: String): Session {
        return wrapRemoteResponse {
            remoteDataSource.deleteUserSession(sessionId).toSession().also {
                setIsLoggedInByAccount(false)
            }
        }
    }


    private suspend fun setIsLoggedInByGuest(isLogged: Boolean) {
        dataStoreDataSource.setIsLoggedInByGuest(isLogged)
    }


    private suspend fun setIsLoggedInByAccount(isLogged: Boolean) {
        dataStoreDataSource.setIsLoggedInByAccount(isLogged)
    }
    //endregion
}