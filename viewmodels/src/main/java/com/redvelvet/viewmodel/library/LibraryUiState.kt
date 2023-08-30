package com.redvelvet.viewmodel.library

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class LibraryUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val data: LibraryData? = null
) : BaseUiState {
    data class LibraryData(
        val watchLists: List<List<WatchList>> = emptyList(),
        val favoritesList: List<LibraryItems> = emptyList(),
        val historyList: List<LibraryItems> = emptyList()
    ) {
        data class WatchList(
            val id: String = "",
            val name: String = "",
            val count: Int = 0,
            val poster: String = ""
        )

        data class LibraryItems(
            val id: String = "",
            val image: String = "",
            val name: String = "",
            val poster: String = "",
            val type: Type = Type.MOVIE
        )
    }
}

enum class Type(val type: String) {
    MOVIE("movie"), TV("tv")
}