package com.redvelvet.usecase.repository

import com.redvelvet.entities.user.AccountDetails

interface AuthRepository {
    //region auth
    suspend fun loginByGuest()

    suspend fun loginByAccount(userName: String, password: String)

    suspend fun deleteUserSession(sessionId: String)

    suspend fun getAccountDetails(sessionId: String): AccountDetails
    suspend fun getAccountDetailsIdFromLocal(): Int?
    suspend fun getAccountDetailsUsernameFromLocal(): String?

    //endregion
}