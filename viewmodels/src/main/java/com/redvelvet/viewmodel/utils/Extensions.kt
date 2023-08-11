package com.redvelvet.viewmodel.utils

import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.search.SearchCardUiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun CoroutineScope.launchCollectLatest(
    sharedFlow: SharedFlow<BaseUiEffect>,
    block: suspend CoroutineScope.(event: BaseUiEffect) -> Unit
) {
    launch {
        sharedFlow.collectLatest { event -> block(event) }
    }
}

fun SearchCardUiState.getFullImage() = "https://image.tmdb.org/t/p/w500$image"

fun SearchCardUiState.isPerson() = country.isEmpty() && releaseDate.isEmpty()