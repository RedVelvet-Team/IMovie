package com.redvelvet.repository.repository

import com.redvelvet.repository.source.UserPreferencesDataSource
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : UserRepository, BaseRepository() {
    //region user status
    override suspend fun getIsLoggedInByAccount() =
        userPreferencesDataSource.getIsLoggedInByAccount()

    override suspend fun getIsLoggedInByGuest() = userPreferencesDataSource.getIsLoggedInByGuest()

    override suspend fun getGuestSessionIdFromLocal(): String {
        return userPreferencesDataSource.getGuestSessionId().toString()
    }

    override suspend fun getGuestSessionExpDateFromLocal(): String {
        return userPreferencesDataSource.getGuestSessionExpDate().toString()
    }

    override suspend fun getUserSessionIdFromLocal(): String {
        return userPreferencesDataSource.getUserSessionId().toString()
    }
    //endregion
}
