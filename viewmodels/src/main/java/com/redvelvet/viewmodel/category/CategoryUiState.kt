package com.redvelvet.viewmodel.category

import com.redvelvet.entities.Genre
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.MediaType


data class MediaTypeUiState(
    val title: String = "",
    val type: MediaType = MediaType.MOVIE,
    val genreTvList: List<GenreUiState> = emptyList(),
    val genreMovieList: List<GenreUiState> = emptyList(),
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
) : BaseUiState

data class GenreUiState(
    val id: String = "",
    val name: String = "",
)

fun Genre.toGenreUiState() = GenreUiState(
    id = this.id.toString(),
    name = this.name,
)