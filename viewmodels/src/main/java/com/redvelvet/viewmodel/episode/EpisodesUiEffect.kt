package com.redvelvet.viewmodel.seeall.episode

sealed interface EpisodesUiEffect{
    data object NavigateToEpisodeDetailsScreen : EpisodesUiEffect
}
