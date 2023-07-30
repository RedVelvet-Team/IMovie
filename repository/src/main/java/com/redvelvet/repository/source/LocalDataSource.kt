package com.redvelvet.repository.source

interface LocalDataSource {
    suspend fun setIsLoggedByAccount(isLogged: Boolean)
    suspend fun getIsLoggedByAccount(): Boolean

    suspend fun setIsLoggedByGuest(isLogged: Boolean)
    suspend fun getIsLoggedByGuest(): Boolean

    suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean)
    suspend fun getIsFirstTimeUsingApp(): Boolean
}