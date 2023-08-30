package com.redvelvet.viewmodel.library

import com.redvelvet.entities.library.LibraryMovie
import com.redvelvet.entities.library.LibraryTv

fun LibraryMovie.toUiState(): LibraryUiState.LibraryData.LibraryItems {
    return LibraryUiState.LibraryData.LibraryItems(
        id = this.id.toString(),
        name = this.title,
        poster = this.posterPath,
        type = Type.MOVIE
    )
}

fun LibraryTv.toUiState(): LibraryUiState.LibraryData.LibraryItems {
    return LibraryUiState.LibraryData.LibraryItems(
        id = this.id.toString(),
        name = this.name,
        poster = this.posterPath,
        type = Type.TV
    )
}