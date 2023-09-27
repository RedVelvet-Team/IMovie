package com.redvelvet.viewmodel.search

import androidx.paging.PagingData
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.SearchMedia
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class SearchUiState(
    val isLoading: Boolean = false,
    val error: ErrorUiState? = null,
    val selectedMediaType: SearchMedia = SearchMedia.MOVIE,
    val inputText: String = "",
    val searchResult: Flow<PagingData<SearchCardUiState>> = flow { },
    val isEmpty: Boolean = true,
    val categories : List<CategoryUiState> = listOf(
        CategoryUiState(text = "Movie", type = SearchMedia.MOVIE),
        CategoryUiState(text = "Tv show", type = SearchMedia.TV),
        CategoryUiState(text = "Person", type = SearchMedia.PEOPLE),
    )
) : BaseUiState

data class SearchCardUiState(
    val id: Int = 0,
    val name: String = "",
    val image: String = "",
    val type: String = "",
    val releaseDate: String = "",
    val country: String = "",
)

data class CategoryUiState(
    val text: String = "",
    val type: SearchMedia = SearchMedia.MOVIE
)