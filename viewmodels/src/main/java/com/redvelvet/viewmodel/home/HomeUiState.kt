package com.redvelvet.viewmodel.home

import com.redvelvet.viewmodel.base.BaseUiState

data class HomeUiState(
    val popularMovie: MovieUiState? = null,
    val nowPlayingMovies: List<MovieUiState> = emptyList(),
    val upComingMovies: List<MovieUiState> = emptyList(),
    val topRatedMovies: List<MovieUiState> = emptyList(),
    val popularSeries: SeriesUiState? = null,
    val airingTodayMovies: List<SeriesUiState> = emptyList(),
    val onTvSeries: List<SeriesUiState> = emptyList(),
    val topRatedSeries: List<SeriesUiState> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
): BaseUiState

data class MovieUiState(
    val movieImage: String,
    val movieName: String,
    val movieDate: String,
    val countryOfMovie: String,
)

data class SeriesUiState(
    val seriesImage: String,
    val seriesName: String,
    val seriesDate: String,
)
