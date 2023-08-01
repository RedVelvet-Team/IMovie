package com.redvelvet.usecase.repository

import com.redvelvet.entities.user.Token

interface UserRepository {
    suspend fun setIsLoggedByAccount(isLogged: Boolean)
    suspend fun getIsLoggedByAccount(): Boolean

    suspend fun setIsLoggedByGuest(isLogged: Boolean)
    suspend fun getIsLoggedByGuest(): Boolean

    suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean)
    suspend fun getIsFirstTimeUsingApp(): Boolean

    suspend fun getNewRequestToken(): Token
}