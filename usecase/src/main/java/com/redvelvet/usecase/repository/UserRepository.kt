package com.redvelvet.usecase.repository

import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.entities.auth.Token

interface UserRepository {
    suspend fun setIsLoggedByAccount(isLogged: Boolean)
    suspend fun getIsLoggedByAccount(): Boolean

    suspend fun setIsLoggedByGuest(isLogged: Boolean)
    suspend fun getIsLoggedByGuest(): Boolean

    suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean)
    suspend fun getIsFirstTimeUsingApp(): Boolean

    suspend fun createGuestSession(): Guest
    suspend fun createToken(): Token
    suspend fun validateUserWithLogin(userName: String, password: String): Token
    suspend fun createUserSession(): Session
    suspend fun deleteUserSession(): Session
    suspend fun getGuestSessionFromLocal()
    suspend fun saveGuestSession(id: String, expDate: String)
}