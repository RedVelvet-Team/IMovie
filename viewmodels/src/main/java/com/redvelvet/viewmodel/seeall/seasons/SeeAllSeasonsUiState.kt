package com.redvelvet.viewmodel.seeall.seasons

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class SeeAllSeasonsUiState(
    val seasons: List<SeasonUiState> = emptyList(),
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
) : BaseUiState

data class SeasonUiState(
    val imageUrl: String = "",
    val seasonNumber: Int = 0,
    val rate: Double = 0.0,
    val airDate: String = "0",
    val episodeCount: Int = 0,
    val description: String = ""
)