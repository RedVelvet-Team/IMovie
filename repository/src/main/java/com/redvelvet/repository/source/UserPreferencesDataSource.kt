package com.redvelvet.repository.source

interface UserPreferencesDataSource {
    // region user
    suspend fun setIsLoggedInByAccount(isLogged: Boolean)
    suspend fun getIsLoggedInByAccount(): Boolean

    suspend fun setIsLoggedInByGuest(isLogged: Boolean)
    suspend fun getIsLoggedInByGuest(): Boolean
    //endregion

    // region auth
    suspend fun setUserSessionId(id: String)

    fun getUserSessionId(): String?

    suspend fun setGuestSession(id: String, expDate: String)

    fun getGuestSessionId(): String?

    fun getGuestSessionExpDate(): String?

    suspend fun setToken(token: String)

    suspend fun getToken(): String?
    //endregion
}