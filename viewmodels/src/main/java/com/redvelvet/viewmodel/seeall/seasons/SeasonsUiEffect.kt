package com.redvelvet.viewmodel.seeall.seasons

sealed interface SeasonsUiEffect {
    data object NavigateToEpisodesScreen : SeasonsUiEffect
}