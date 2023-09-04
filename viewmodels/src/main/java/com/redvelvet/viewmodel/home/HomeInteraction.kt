package com.redvelvet.viewmodel.home

import com.redvelvet.viewmodel.utils.MediaType

interface HomeInteraction {
    fun onChangeCategoryTab(mediaType: MediaType)
    fun onCLickRefresh()
}