package com.redvelvet.repository.mapper

import com.redvelvet.entities.Player
import com.redvelvet.repository.dto.PlayerDto

fun PlayerDto.toEntity() = Player(
    accountId = this.accountId ?: 0,
    name = this.name ?: "",
    score = this.score ?: 0,
    avatarId = this.avatarId ?: "0"
)

fun Player.toDto() = PlayerDto(
    accountId = this.accountId,
    name = this.name,
    score = this.score,
    avatarId = this.accountId.toString()
)