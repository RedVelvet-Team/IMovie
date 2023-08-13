package com.redvelvet.repository.repository

import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.repository.source.UserPreferencesDataSource
import com.redvelvet.usecase.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : BaseRepository(), AuthRepository {
    //region auth

    //region guest
    override suspend fun loginByGuest() {
        return wrapRemoteResponse {
            remoteDataSource.createGuestSession().also { guest ->
                saveGuestSession(
                    id = guest.guestSessionId.toString(),
                    expDate = guest.expiresAt.toString()
                )
                setIsLoggedInByGuest(true)
            }
        }
    }

    private suspend fun saveGuestSession(id: String, expDate: String) {
        userPreferencesDataSource.setGuestSession(id, expDate)
    }
    //endregion

    //region token
    private suspend fun validateTokenWithLogin(
        userName: String,
        password: String,
    ): String {
        return wrapRemoteResponse {
            remoteDataSource.validateUserWithLogin(
                userName = userName,
                password = password,
                requestToken = createRequestToken()
            ).requestToken.toString()
        }
    }

    private suspend fun createRequestToken(): String {
        return wrapRemoteResponse {
            remoteDataSource.createToken().requestToken.toString()
        }
    }
    //endregion

    //region session
    override suspend fun loginByAccount(userName: String, password: String) {
        return wrapRemoteResponse {
            val token = validateTokenWithLogin(userName, password)
            remoteDataSource.createUserSession(token).also { session ->
                saveUserSessionId(session.sessionId.toString())
                setIsLoggedInByAccount(true)
                setIsLoggedInByGuest(false)
            }
        }
    }

    private suspend fun saveUserSessionId(id: String) {
        userPreferencesDataSource.setUserSessionId(id = id)
    }


    override suspend fun deleteUserSession(sessionId: String) {
        return wrapRemoteResponse {
            remoteDataSource.deleteUserSession(sessionId).also {
                setIsLoggedInByAccount(false)
            }
        }
    }
    //endregion

    //region user status
    private suspend fun setIsLoggedInByGuest(isLogged: Boolean) {
        userPreferencesDataSource.setIsLoggedInByGuest(isLogged)
    }


    private suspend fun setIsLoggedInByAccount(isLogged: Boolean) {
        userPreferencesDataSource.setIsLoggedInByAccount(isLogged)
    }
    //endregion

    //endregion
}