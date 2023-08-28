package com.redvelvet.viewmodel.category

interface CategoryInteraction {
    fun onClickCard(categoryId: String, categoryType: String)
    fun onClickMovieCategoryTab()
    fun onClickTvCategoryTab()
    fun onCLickRefresh()
}