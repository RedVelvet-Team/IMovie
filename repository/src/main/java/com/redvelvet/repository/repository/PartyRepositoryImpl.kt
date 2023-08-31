package com.redvelvet.repository.repository

import com.redvelvet.entities.MovieParty
import com.redvelvet.repository.mapper.toMovieParty
import com.redvelvet.repository.source.RealTimeDataSource
import com.redvelvet.repository.source.UserPreferencesDataSource
import com.redvelvet.usecase.repository.PartyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PartyRepositoryImpl @Inject constructor(
    private val realTimeDataSource: RealTimeDataSource,
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : PartyRepository {

    override suspend fun createRoom(userName: String, partyId: String) {
        return realTimeDataSource.createRoom(
            userPreferencesDataSource.getUserName().toString(),
            partyId
        )
    }

    override suspend fun joinRoom(id: String) {
        return realTimeDataSource.joinRoom(id)
    }

    override suspend fun streamMovie(roomId: String): Flow<MovieParty> {
        return realTimeDataSource.streamMovie(roomId).map {
            it.toMovieParty()
        }
    }
}