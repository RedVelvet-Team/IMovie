package com.redvelvet.usecase.repository

interface AuthRepository {
    //region auth
    suspend fun loginByGuest()

    suspend fun loginByAccount(userName: String, password: String)

    suspend fun deleteUserSession(sessionId: String)
    //endregion
}