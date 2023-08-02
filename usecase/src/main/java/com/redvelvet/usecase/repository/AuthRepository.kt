package com.redvelvet.usecase.repository

import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.entities.auth.Token

interface AuthRepository {
    //region auth
    suspend fun setIsLoggedInByAccount(isLogged: Boolean)
    suspend fun setIsLoggedInByGuest(isLogged: Boolean)
    suspend fun createGuestSession(): Guest

    suspend fun createToken(): Token

    suspend fun validateUserWithLogin(userName: String, password: String): Token

    suspend fun createUserSession(): Session

    suspend fun deleteUserSession(): Session

    suspend fun saveGuestSession(id: String, expDate: String)
    //endregion
}