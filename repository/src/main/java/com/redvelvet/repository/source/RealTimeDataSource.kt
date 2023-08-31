package com.redvelvet.repository.source

import com.redvelvet.repository.dto.party.MoviePartyDto
import kotlinx.coroutines.flow.Flow


interface RealTimeDataSource {
    suspend fun createRoom(userName: String, partyId: String)
    suspend fun joinRoom(id: String)
    suspend fun streamMovie(roomId: String): Flow<MoviePartyDto>
}