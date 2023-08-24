package com.redvelvet.viewmodel.episode

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class EpisodeDetailsUiState(
    val data: Episode? = null,
    val isLoading: Boolean = true,
    val isError: ErrorUiState? = null,
) : BaseUiState

