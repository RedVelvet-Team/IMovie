package com.redvelvet.repository.source

interface LocalDataSource {
    suspend fun setIsLoggedByAccount(isLogged: Boolean)
    suspend fun getIsLoggedByAccount(): Boolean

    suspend fun setIsLoggedByGuest(isLogged: Boolean)
    suspend fun getIsLoggedByGuest(): Boolean

    suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean)
    suspend fun getIsFirstTimeUsingApp(): Boolean

    suspend fun setToken(value: String)

    fun getToken(): String?

    suspend fun setSessionId(value: String)

    fun getSessionId(): String?

}