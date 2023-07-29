package com.redvelvet.repository.repository

import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : UserRepository {
    override suspend fun setIsLoggedByAccount(isLogged: Boolean) {
        localDataSource.setIsLoggedByAccount(isLogged)
    }

    override suspend fun getIsLoggedByAccount() = localDataSource.getIsLoggedByAccount()

    override suspend fun setIsLoggedByGuest(isLogged: Boolean) {
        localDataSource.setIsLoggedByGuest(isLogged)
    }

    override suspend fun getIsLoggedByGuest() = localDataSource.getIsLoggedByGuest()
    override suspend fun setIsFirstTimeUsingApp(isFirstTime: Boolean) {
        localDataSource.setIsFirstTimeUsingApp(isFirstTime)
    }

    override suspend fun getIsFirstTimeUsingApp() = localDataSource.getIsFirstTimeUsingApp()

}
