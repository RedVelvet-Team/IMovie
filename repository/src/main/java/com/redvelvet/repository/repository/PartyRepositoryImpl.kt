package com.redvelvet.repository.repository

import android.security.keystore.UserNotAuthenticatedException
import com.redvelvet.entities.MovieParty
import com.redvelvet.repository.mapper.toMovieParty
import com.redvelvet.repository.source.RealTimeDataSource
import com.redvelvet.repository.source.UserPreferencesDataSource
import com.redvelvet.usecase.repository.PartyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PartyRepositoryImpl @Inject constructor(
    private val realTimeDataSource: RealTimeDataSource,
    private val userPreferencesDataSource: UserPreferencesDataSource,
) : PartyRepository {

    override suspend fun createRoom(userName: String, partyId: String) {
        if (userPreferencesDataSource.getIsLoggedInByAccount())
            return realTimeDataSource.createRoom(
                userPreferencesDataSource.getUserName().toString(),
                partyId
            )
        throw UserNotAuthenticatedException("You have to login to create or join room")
    }

    override suspend fun joinRoom(id: String) {
        if (userPreferencesDataSource.getIsLoggedInByAccount())
            return realTimeDataSource.joinRoom(id)

        throw UserNotAuthenticatedException("You have to login to create or join room")
    }

    override suspend fun streamMovie(roomId: String): Flow<MovieParty> {
        return realTimeDataSource.streamMovie(roomId).map {
            it.toMovieParty()
        }
    }
}