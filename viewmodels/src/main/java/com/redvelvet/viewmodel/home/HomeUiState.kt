package com.redvelvet.viewmodel.home

import com.redvelvet.viewmodel.base.BaseUiState

data class HomeUiState(
    val movieCategories: List<ItemsUiState> = emptyList(),
    val tvShowCategories: List<ItemsUiState> = emptyList(),
    val tabLayoutTitles: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val isError: String? = null,
) : BaseUiState

data class ItemsUiState(
    val title: String = "",
    val items: List<ItemUiState>,
    val hasMore: Boolean = false
)

data class ItemUiState(
    val id: String = "",
    val image: String = "",
    val name: String = "",
    val date: String = "",
    val country: String = "",
)
