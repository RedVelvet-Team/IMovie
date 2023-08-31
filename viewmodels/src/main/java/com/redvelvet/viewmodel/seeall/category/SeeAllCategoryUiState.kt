package com.redvelvet.viewmodel.seeall.category

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SeeAllCategoryUiState(
    val title: String = "",
    val media: Flow<PagingData<MediaUiState>> = flow { },
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
) : BaseUiState

data class MediaUiState(
    val id: String = "",
    val imageUrl: String = "",
    val name: String = "",
    val date: String = "",
    val country: String = "",
)

fun Movie.toMediaUiState() = MediaUiState(
    id = this.id.toString(),
    imageUrl = Constants.BASE_IMAGE_URL + this.movieImageUrl,
    name = this.name,
    date = this.releaseDate,
    country = this.country
)

fun TvShow.toMediaUiState() = MediaUiState(
    id = this.id.toString(),
    imageUrl = Constants.BASE_IMAGE_URL + this.imageUrl,
    name = this.name,
    date = this.releaseDate,
    country = this.country
)