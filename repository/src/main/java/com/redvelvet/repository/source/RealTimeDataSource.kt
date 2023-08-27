package com.redvelvet.repository.source

import com.redvelvet.repository.dto.PlayerDto

interface RealTimeDataSource {

    suspend fun getUserScore(accountId: Int): PlayerDto
    suspend fun getHighestScore(): List<PlayerDto>

    suspend fun saveUserScore(score: Int, accountId: Int)

    suspend fun addPlayer(player: PlayerDto)

}