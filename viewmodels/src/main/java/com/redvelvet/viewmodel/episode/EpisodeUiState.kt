package com.redvelvet.viewmodel.seeall.episode

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class EpisodeUiState(
    val episodes: List<EpisodeCardUiState> = emptyList(),
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
) : BaseUiState

data class EpisodeCardUiState(
    val id: Int = 0,
    val name: String = "",
    val airDate: String = "",
    val voteAverage: Double = 0.0,
    val runtime: Int = 0,
    val image: String = ""
)

