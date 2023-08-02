package com.redvelvet.repository.source

interface DataStoreDataSource {
    suspend fun setIsLoggedByAccount(isLogged: Boolean)
    suspend fun getIsLoggedByAccount(): Boolean

    suspend fun setIsLoggedByGuest(isLogged: Boolean)
    suspend fun getIsLoggedByGuest(): Boolean

    suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean)
    suspend fun getIsFirstTimeUsingApp(): Boolean

    suspend fun setToken(token: String)

    fun getToken(): String?

    suspend fun setSessionId(id: String)

    fun getSessionId(): String?

    suspend fun setGuestSessionId(id: String)

    fun getGuestSessionId(): String?

    suspend fun setGuestSessionExpDate(expiresAt: String)

    fun getGuestSessionExpDate(): String?

}