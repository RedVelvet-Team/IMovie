package com.redvelvet.viewmodel.seeall.movie

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.home.MovieUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SeeAllMovieUiState(
    val title: String = "",
    val movies: Flow<PagingData<MovieUiState>> = flow { },
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
): BaseUiState


fun Movie.toMovieUiState() = MovieUiState(
    id = this.id.toString(),
    imageUrl = "https://image.tmdb.org/t/p/w500" + this.movieImageUrl,
    name = this.name,
    date = this.releaseDate,
    country = this.country
)