package com.redvelvet.viewmodel.category

import com.redvelvet.viewmodel.utils.MediaType

interface CategoryInteraction {
    fun onClickCard(categoryId: String, categoryType: String)
    fun onChangeCategoryTab(mediaType: MediaType)
    fun onCLickRefresh()
}