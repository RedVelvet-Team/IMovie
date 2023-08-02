package com.redvelvet.repository.source

interface DataStoreDataSource {
    // region user
    suspend fun setIsLoggedByAccount(isLogged: Boolean)
    suspend fun getIsLoggedByAccount(): Boolean

    suspend fun setIsLoggedByGuest(isLogged: Boolean)
    suspend fun getIsLoggedByGuest(): Boolean

    suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean)
    suspend fun getIsFirstTimeUsingApp(): Boolean
    //endregion

    // region auth
    suspend fun setUserSessionId(id: String)

    fun getUserSessionId(): String?

    suspend fun setGuestSession(id: String, expDate: String)

    fun getGuestSessionId(): String?

    fun getGuestSessionExpDate(): String?
    //endregion
}