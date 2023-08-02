package com.redvelvet.repository.repository

import com.redvelvet.repository.source.DataStoreDataSource
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val dataStoreDataSource: DataStoreDataSource,
) : UserRepository, BaseRepository() {
    //region user
    override suspend fun getIsLoggedInByAccount() = dataStoreDataSource.getIsLoggedByAccount()

    override suspend fun getIsLoggedInByGuest() = dataStoreDataSource.getIsLoggedByGuest()

    override suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean) {
        dataStoreDataSource.setIsFirstTimeUsingApp(isFirstTime)
    }

    override suspend fun getIsFirstTimeUsingApp() = dataStoreDataSource.getIsFirstTimeUsingApp()
    //endregion

    //region auth
    override suspend fun getGuestSessionIdFromLocal(): String {
        return dataStoreDataSource.getGuestSessionId().toString()
    }

    override suspend fun getGuestSessionExpDateFromLocal(): String {
        return dataStoreDataSource.getGuestSessionExpDate().toString()
    }

    override suspend fun getUserSessionId(): String {
        return dataStoreDataSource.getUserSessionId().toString()
    }

    //endregion
}
