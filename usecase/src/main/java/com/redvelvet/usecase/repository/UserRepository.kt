package com.redvelvet.usecase.repository

import com.redvelvet.entities.user.User

interface UserRepository {
    //region user
    suspend fun getIsLoggedInByAccount(): Boolean

    suspend fun getIsLoggedInByGuest(): Boolean
    //endregion

    //region auth
    suspend fun getGuestSessionExpDateFromLocal(): String

    suspend fun getGuestSessionIdFromLocal(): String

    suspend fun getUserSessionIdFromLocal(): String

    suspend fun getUserNameFromLocal(): String

    suspend fun setUserName(userName: String)

    //endregion
}