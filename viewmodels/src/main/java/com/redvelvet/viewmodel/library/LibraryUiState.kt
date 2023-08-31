package com.redvelvet.viewmodel.library

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class LibraryUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val data: LibraryData? = null,
    val bottomSheet: Boolean = false
) : BaseUiState {
    data class LibraryData(
        val watchLists: List<CreatedListUiState> = emptyList(),
        val favoritesList: List<WatchListUiState> = emptyList(),
        val historyList: List<WatchListUiState> = emptyList()
    ) {
        data class CreatedListUiState(
            val favoriteCount: Int,
            val id: Int,
            val itemCount: Int,
            val listType: String,
            val name: String,
            val posterPath: String
        )

        data class WatchListUiState(
            val id: Int,
            val posterPath: String,
            val name: String,
            val type: String
        )
    }
}