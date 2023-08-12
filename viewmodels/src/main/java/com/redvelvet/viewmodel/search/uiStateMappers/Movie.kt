package com.redvelvet.viewmodel.search.uiStateMappers

import com.redvelvet.entities.movie.Movie
import com.redvelvet.viewmodel.search.SearchCardUiState

fun Movie.toSearchCardUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id,
        name = name,
        image = movieImageUrl,
        type = "Movie",
        releaseDate = releaseDate,
        country = country
    )
}