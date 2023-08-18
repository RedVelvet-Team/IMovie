package com.redvelvet.viewmodel.home

import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.Constants.BASE_IMAGE_URL

data class HomeUiState(
    val movieCategories: List<ItemsUiState> = emptyList(),
    val tvShowCategories: List<ItemsUiState> = emptyList(),
    val tabLayoutTitles: List<String> = listOf("Movies", "TV Shows"),
    val isLoading: Boolean = true,
    val isError: ErrorUiState? = null,
) : BaseUiState

data class ItemsUiState(
    val title: String = "",
    val items: List<ItemUiState>,
    val hasMore: Boolean = true
)

data class ItemUiState(
    val id: String = "",
    val image: String = "",
    val name: String = "",
    val date: String = "",
    val country: String = "",
)


fun Movie.toItemUiState(): ItemUiState {
    return ItemUiState(
        id = id.toString(),
        image = BASE_IMAGE_URL + this.movieImageUrl,
        name = this.name,
        date = releaseDate,
        country = this.country
    )
}
