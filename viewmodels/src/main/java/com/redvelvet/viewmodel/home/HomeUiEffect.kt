package com.redvelvet.viewmodel.home

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class HomeUiEffect() : BaseUiEffect {
    data object NavigateUp : HomeUiEffect()
}