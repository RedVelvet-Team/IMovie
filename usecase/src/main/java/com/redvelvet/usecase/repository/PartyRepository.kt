package com.redvelvet.usecase.repository

import com.redvelvet.entities.MovieParty
import kotlinx.coroutines.flow.Flow

interface PartyRepository {
     suspend fun createRoom(userName: String, partyId: String)

     suspend fun joinRoom(id: String)

     suspend fun streamMovie(roomId: String): Flow<MovieParty>
}