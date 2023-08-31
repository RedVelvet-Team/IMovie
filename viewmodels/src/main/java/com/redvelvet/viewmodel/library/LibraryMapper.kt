package com.redvelvet.viewmodel.library

import com.redvelvet.entities.library.LibraryDetails

fun LibraryDetails.toUiState(): LibraryUiState {
    return LibraryUiState(isLoading = true,
        error = null,
        data = LibraryUiState.LibraryData(watchLists = this.createdLists.results.map {
            LibraryUiState.LibraryData.CreatedListUiState(
                it.favoriteCount, it.id, it.itemCount, it.listType, it.name, it.posterPath
            )
        }, favoritesList = this.movieFavorites.data.map {
            LibraryUiState.LibraryData.WatchListUiState(
                it.id, it.posterPath, it.name, it.type.name
            )
        } + this.tvFavorites.data.map {
            LibraryUiState.LibraryData.WatchListUiState(
                it.id, it.posterPath, it.name, it.type.name
            )
        })
    )
}