package com.redvelvet.viewmodel.seeall.category

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class SeeAllCategoriesUiEffect() : BaseUiEffect {
    data class NavigateToMovieDetailsScreen(val id: String) :
        SeeAllCategoriesUiEffect()

    data class NavigateToTvDetailsScreen(val id: String) :
        SeeAllCategoriesUiEffect()


    data object NavigateUp : SeeAllCategoriesUiEffect()
}
