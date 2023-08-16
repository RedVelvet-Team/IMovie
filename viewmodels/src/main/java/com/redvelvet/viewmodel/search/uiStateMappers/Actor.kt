package com.redvelvet.viewmodel.search.uiStateMappers

import com.redvelvet.entities.actor.Actor
import com.redvelvet.viewmodel.search.SearchCardUiState

fun Actor.toSearchCardUiState(): SearchCardUiState {
    return SearchCardUiState(
        id = id,
        name = name,
        image = profileImageUrl,
        type = "People",
        releaseDate = birthday ?: "",
        country = this.placeOfBirth
    )
}