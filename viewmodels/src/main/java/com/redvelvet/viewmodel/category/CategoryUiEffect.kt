package com.redvelvet.viewmodel.category

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class CategoryUiEffect() : BaseUiEffect {
//    data class NavigateToSeeAllCategoryScreen(val id: String, var title: String, val type: String) :
//        CategoryUiEffect()

    data object NavigateUp : CategoryUiEffect()
}