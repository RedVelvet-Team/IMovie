package com.redvelvet.viewmodel.search

import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.home.HomeUiEffect

sealed class SearchUiEffect() : BaseUiEffect {
    data object NavigateUp : SearchUiEffect()

}