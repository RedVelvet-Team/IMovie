package com.redvelvet.viewmodel.see_all_episode

sealed interface SeeAllEpisodesUiEffect {
    data class NavigateToEpisodeDetailsScreen(
        val tvId: Int,
        val seasonId: Int,
        val episodeId :Int,
        val sessionId:String
    ) : SeeAllEpisodesUiEffect
}