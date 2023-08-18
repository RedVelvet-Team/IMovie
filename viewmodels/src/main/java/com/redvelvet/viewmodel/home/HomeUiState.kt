package com.redvelvet.viewmodel.home

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.Constants.BASE_IMAGE_URL

data class HomeUiState(
    val movieCategories: List<ItemsUiState> = emptyList(),
    val tvShowCategories: List<ItemsUiState> = emptyList(),
    val tabLayoutTitles: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val isError: ErrorUiState? = null,
) : BaseUiState

data class ItemsUiState(
    val title: String = "",
    val items: List<ItemUiState>,
    val hasMore: Boolean = false
)

data class ItemUiState(
    val id: String = "",
    val image: String = "",
    val name: String = "",
    val date: String = "",
    val country: String = "",
)

fun MovieDetails.toItemUiState(): ItemUiState {
    return ItemUiState(
        id = id.toString(),
        image = BASE_IMAGE_URL + posterPath,
        name = title,
        date = releaseDate,
        country = productionCountries[0].name
    )
}
