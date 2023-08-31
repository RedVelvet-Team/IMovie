package com.redvelvet.viewmodel.category

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class CategoryUiEffect() : BaseUiEffect {
    data class NavigateToSeeAllCategoryScreen(val id: String, var name: String) :
        CategoryUiEffect()

    data object NavigateUp : CategoryUiEffect()
}