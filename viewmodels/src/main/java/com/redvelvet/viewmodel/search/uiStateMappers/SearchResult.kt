package com.redvelvet.viewmodel.search.uiStateMappers

import com.redvelvet.entities.search.SearchResult
import com.redvelvet.viewmodel.search.SearchCardUiState

fun SearchResult.toSearchCardUiState(): SearchCardUiState {
    val mediaName = name.ifEmpty { originalName }
    val image = posterPath.ifEmpty { profilePath }
    val date = firstAirDate.ifEmpty { releaseDate }

    return SearchCardUiState(
        id = id,
        name = mediaName,
        image = image,
        type = mediaType,
        releaseDate = date,
        country = language
    )
}