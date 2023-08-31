package com.redvelvet.viewmodel.game

import com.redvelvet.entities.Player
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.MediaType

data class GameScoreUiState(
    val isLoading: Boolean = true,
    val canJoinGame: Boolean = true,
    val error: ErrorUiState? = null,
    val type: MediaType = MediaType.MOVIE,
    val userInfo: PlayerInfoUiState = PlayerInfoUiState(),
    val highestScorePlayer: List<PlayerInfoUiState> = listOf()
): BaseUiState

data class PlayerInfoUiState(
    val name: String = "",
    val score: String = "",
    val avatarId: String = "",
    val rank: Int = 0,
)

fun Player.toUiState() = PlayerInfoUiState(
    name = this.name,
    score = this.score.toString(),
    avatarId = this.avatarId,
    rank = this.rank
)