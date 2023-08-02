package com.redvelvet.usecase.repository

import com.redvelvet.entities.auth.Guest
import com.redvelvet.entities.auth.Session
import com.redvelvet.entities.auth.Token

interface AuthRepository {
    suspend fun createGuestSession(): Guest
    suspend fun createToken(): Token
    suspend fun validateUserWithLogin(userName: String, password: String): Token
    suspend fun createUserSession(): Session
    suspend fun deleteUserSession(): Session
    suspend fun getGuestSessionIdFromLocal():String
    suspend fun saveGuestSession(id: String, expDate: String)
    suspend fun getGuestSessionExpDateFromLocal(): String
}