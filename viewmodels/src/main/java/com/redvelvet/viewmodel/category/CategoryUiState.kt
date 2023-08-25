package com.redvelvet.viewmodel.category

import com.redvelvet.entities.Genre
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState


data class MediaTypeUiState(
    val title: String = "",
    val type: List<String> = listOf("Movies", "TV Shows"),
    val genreList: List<GenreUiState> = emptyList(),
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