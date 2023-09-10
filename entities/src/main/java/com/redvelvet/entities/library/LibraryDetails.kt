package com.redvelvet.entities.library

import com.redvelvet.entities.library.list.CreatedLists

data class LibraryDetails(
    val createdLists: CreatedLists,
    val movieFavorites: WatchListMedia,
    val tvFavorites: WatchListMedia,
)
