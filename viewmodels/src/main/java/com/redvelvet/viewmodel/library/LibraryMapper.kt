package com.redvelvet.viewmodel.library

import com.redvelvet.entities.library.WatchListMedia

fun WatchListMedia.Data.toUiStateModel(): LibraryUiState.LibraryData.LibraryItems {
    return LibraryUiState.LibraryData.LibraryItems(
        id = this.id.toString(),
        name = this.name,
        poster = this.posterPath,
        type = Type.MOVIE
    )
}

fun WatchListMedia.Data.toUiState(): LibraryUiState.LibraryData.LibraryItems {
    return LibraryUiState.LibraryData.LibraryItems(
        id = this.id.toString(),
        name = this.name,
        poster = this.posterPath,
        type = Type.TV
    )
}