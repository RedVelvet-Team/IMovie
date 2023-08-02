package com.redvelvet.repository.repository

import com.redvelvet.repository.source.DataStoreDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dataStoreDataSource: DataStoreDataSource,
) : UserRepository, BaseRepository() {
    override suspend fun setIsLoggedByAccount(isLogged: Boolean) {
        dataStoreDataSource.setIsLoggedByAccount(isLogged)
    }

    override suspend fun getIsLoggedByAccount() = dataStoreDataSource.getIsLoggedByAccount()

    override suspend fun setIsLoggedByGuest(isLogged: Boolean) {
        dataStoreDataSource.setIsLoggedByGuest(isLogged)
    }

    override suspend fun getIsLoggedByGuest() = dataStoreDataSource.getIsLoggedByGuest()
    override suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean) {
        dataStoreDataSource.setIsFirstTimeUsingApp(isFirstTime)
    }

    override suspend fun getIsFirstTimeUsingApp() = dataStoreDataSource.getIsFirstTimeUsingApp()
}
