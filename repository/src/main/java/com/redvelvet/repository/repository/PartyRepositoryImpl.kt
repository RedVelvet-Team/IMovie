package com.redvelvet.repository.repository

import com.redvelvet.repository.source.RealTimeDataSource
import com.redvelvet.repository.source.UserPreferencesDataSource
import com.redvelvet.usecase.repository.PartyRepository
import javax.inject.Inject

class PartyRepositoryImpl @Inject constructor(
    private val realTimeDataSource: RealTimeDataSource,
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : PartyRepository {

    override suspend fun createRoom(userName: String) {
        return realTimeDataSource.createRoom(userPreferencesDataSource.getUserName().toString())
    }

    override suspend fun joinRoom(id: String) {
        return realTimeDataSource.joinRoom(id)
    }
}