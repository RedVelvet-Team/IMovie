package com.redvelvet.repository.source

import com.redvelvet.repository.dto.PlayerDto

interface RealTimeDataSource {

    suspend fun getUserScore(accountId: Int): Pair<PlayerDto, Int>
    suspend fun getHighestScorePlayers(): List<Pair<PlayerDto, Int>>

    suspend fun saveUserScore(score: Int, accountId: Int)

    suspend fun addPlayer(player: PlayerDto)

}