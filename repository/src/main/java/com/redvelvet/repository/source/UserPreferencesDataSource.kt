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

    suspend fun getUserSessionId(): String?

    suspend fun setGuestSession(id: String, expDate: String)

    suspend fun getGuestSessionId(): String?

    suspend fun getGuestSessionExpDate(): String?
    //endregion

    suspend fun setAccountDetailsId(accountId: Int)
    suspend fun setAccountDetailsUsername(accountUsername: String)

    suspend fun getAccountDetailsIdFromLocal(): Int?
    suspend fun getAccountDetailsUsernameFromLocal(): String?
}