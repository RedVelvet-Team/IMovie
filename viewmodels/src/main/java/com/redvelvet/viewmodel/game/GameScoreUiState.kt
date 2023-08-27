package com.redvelvet.viewmodel.game

import com.redvelvet.entities.Player
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class GameScoreUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val userInfo: PlayerInfoUiState = PlayerInfoUiState(),
    val highestScorePlayer: List<PlayerInfoUiState> = listOf()
): BaseUiState

data class PlayerInfoUiState(
    val name: String = "",
    val score: String = ""
)

fun Player.toUiState() = PlayerInfoUiState(
    name = this.name,
    score = this.score.toString()
)