package com.redvelvet.viewmodel.see_all_episode

import androidx.lifecycle.SavedStateHandle

class EpisodesArgs(savedStateHandle: SavedStateHandle) {
    val tvId: String = savedStateHandle[TV_ID] ?: "0"
    val seasonNumber: String = savedStateHandle[SEASON_Number] ?: "0"
    companion object{
        const val TV_ID = "tv_id"
        const val SEASON_Number = "season_number"
    }
}