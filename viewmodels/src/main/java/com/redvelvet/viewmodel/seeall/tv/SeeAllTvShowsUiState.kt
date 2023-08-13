package com.redvelvet.viewmodel.seeall.tv

import androidx.paging.PagingData
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.home.TvShowUiState
import com.redvelvet.viewmodel.search.SearchCardUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SeeAllTvShowUiState(
    val title: String = "",
    val tvShows: Flow<PagingData<TvShowUiState>> = flow { },
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
): BaseUiState