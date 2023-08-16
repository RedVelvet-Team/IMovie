package com.redvelvet.viewmodel.utils

import com.redvelvet.viewmodel.search.SearchCardUiState

fun SearchCardUiState.getFullImage() = "https://image.tmdb.org/t/p/w500$image"

fun SearchCardUiState.isPerson() = country.isEmpty() && releaseDate.isEmpty()