package com.redvelvet.viewmodel.search.uiStateMappers

import com.redvelvet.entities.tv.TvShow
import com.redvelvet.viewmodel.search.SearchCardUiState

fun TvShow.toSearchCardUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id,
        name = name,
        image = imageUrl,
        type = "TvShow",
        releaseDate = releaseDate ?: "",
        country = country ?: ""
    )
}