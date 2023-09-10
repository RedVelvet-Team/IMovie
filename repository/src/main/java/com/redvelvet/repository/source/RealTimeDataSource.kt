package com.redvelvet.repository.source

import com.redvelvet.repository.dto.PlayerDto

import com.redvelvet.repository.dto.party.MoviePartyDto
import kotlinx.coroutines.flow.Flow


interface RealTimeDataSource {

    suspend fun getUserScore(accountId: Int): Pair<PlayerDto, Int>
    suspend fun getHighestScorePlayers(): List<Pair<PlayerDto, Int>>

    suspend fun saveUserScore(score: Int, accountId: Int)

    suspend fun addPlayer(player: PlayerDto)

    suspend fun createRoom(userName: String, partyId: String)
    suspend fun joinRoom(id: String)
    suspend fun streamMovie(roomId: String): Flow<MoviePartyDto>
}