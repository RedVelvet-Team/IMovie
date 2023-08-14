package com.redvelvet.viewmodel.seeall.tv

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface SeeAllTvShowsUiEffect : BaseUiEffect {
    data object TvShowsDetails : SeeAllTvShowsUiEffect
}