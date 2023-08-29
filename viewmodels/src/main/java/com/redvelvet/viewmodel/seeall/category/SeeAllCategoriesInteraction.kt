package com.redvelvet.viewmodel.seeall.category

interface SeeAllCategoriesInteraction {
    fun onCLickRefresh()
    fun onClickBack()
    fun onClickCard(categoryId: String)
}