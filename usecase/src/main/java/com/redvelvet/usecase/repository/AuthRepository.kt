package com.redvelvet.usecase.repository

import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.entities.auth.Token

interface AuthRepository {
    //region auth
    suspend fun createGuestSession(): Guest

    suspend fun createToken(): Token

    suspend fun validateUserWithLogin(userName: String, password: String, token: String): Token

    suspend fun createUserSession(token: String): Session

    suspend fun deleteUserSession(sessionId: String): Session

    suspend fun getToken(): String
    //endregion
}