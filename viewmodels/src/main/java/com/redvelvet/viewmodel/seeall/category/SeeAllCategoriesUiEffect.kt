package com.redvelvet.viewmodel.seeall.category

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class SeeAllCategoriesUiEffect() : BaseUiEffect {
    data class NavigateToDetailsScreen(val id: String) :
        SeeAllCategoriesUiEffect()

    data object NavigateUp : SeeAllCategoriesUiEffect()
}
