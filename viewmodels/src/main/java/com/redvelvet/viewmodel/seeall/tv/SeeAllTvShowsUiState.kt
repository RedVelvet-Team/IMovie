package com.redvelvet.viewmodel.seeall.tv

import androidx.paging.PagingData
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.home.TvShowUiState
import com.redvelvet.viewmodel.search.SearchCardUiState
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.home.TvShowUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SeeAllTvShowUiState(
    val id: Int? = null,
    val title: String = "",
    val tvShows: Flow<PagingData<TvShowUiState>> = flow { },
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
) : BaseUiState

fun TvShow.toTvShowUiState() = TvShowUiState(
    seriesImage = "https://image.tmdb.org/t/p/w500" + this.imageUrl,
    seriesName = this.name,
    seriesDate = this.releaseDate,
    seriesCountry = this.country
)
): BaseUiState