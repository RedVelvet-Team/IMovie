package com.redvelvet.viewmodel.episode

import androidx.lifecycle.SavedStateHandle

class EpisodeDetailsArgs(savedStateHandle: SavedStateHandle) {
    val tvId: Int = savedStateHandle[TV_ID] ?: 1
    val seasonId: Int = savedStateHandle[SEASON_ID] ?: 1
    val episodeId: Int = savedStateHandle[EPISODE_ID] ?: 1

    companion object {
        const val TV_ID = "id"
        const val SEASON_ID = "season"
        const val EPISODE_ID = "episode"
    }
}