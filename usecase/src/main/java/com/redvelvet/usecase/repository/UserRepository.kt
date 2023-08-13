package com.redvelvet.usecase.repository

interface UserRepository {
    //region user
    suspend fun getIsLoggedInByAccount(): Boolean

    suspend fun getIsLoggedInByGuest(): Boolean
    //endregion

    //region auth
    suspend fun getGuestSessionExpDateFromLocal(): String

    suspend fun getGuestSessionIdFromLocal(): String

    suspend fun getUserSessionId(): String
    //endregion
}