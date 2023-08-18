package com.redvelvet.viewmodel.episode

import androidx.lifecycle.SavedStateHandle

class EpisodesArgs(savedStateHandle: SavedStateHandle) {
    val tvId: String = savedStateHandle[TV_ID] ?: "0"
    val seasonNumber: Int = savedStateHandle[SEASON_Number] ?: 0
    companion object{
        const val TV_ID = "tv_id"
        const val SEASON_Number = "season_number"
    }
}