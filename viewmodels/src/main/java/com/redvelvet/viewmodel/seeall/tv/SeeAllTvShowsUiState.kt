package com.redvelvet.viewmodel.seeall.tv

import androidx.paging.PagingData
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SeeAllTvShowUiState(
    val id: Int? = null,
    val title: String = "",
    val tvShows: Flow<PagingData<ItemUiState>> = flow { },
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
) : BaseUiState

fun TvShow.toTvShowUiState() = ItemUiState(
    id = id.toString(),
    image = Constants.BASE_IMAGE_URL + this.imageUrl,
    name = this.name,
    date = this.releaseDate,
    country = this.country
)