package com.redvelvet.viewmodel.search

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class SearchUiEffect() : BaseUiEffect {
    data object NavigateUp : SearchUiEffect()

}