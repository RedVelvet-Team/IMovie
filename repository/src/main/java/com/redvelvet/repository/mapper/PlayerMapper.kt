package com.redvelvet.repository.mapper

import com.redvelvet.entities.Player
import com.redvelvet.repository.dto.PlayerDto

fun Pair<PlayerDto, Int>.toEntity() = Player(
    accountId = this.first.accountId ?: 0,
    name = this.first.name ?: "",
    score = this.first.score ?: 0,
    avatarId = this.first.avatarId ?: "0",
    rank = this.second
)

fun Player.toDto() = PlayerDto(
    accountId = this.accountId,
    name = this.name,
    score = this.score,
    avatarId = this.avatarId
)