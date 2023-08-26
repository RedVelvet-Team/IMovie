package com.redvelvet.viewmodel.youtube_player

import androidx.lifecycle.SavedStateHandle

class YoutubePlayerArgs(savedStateHandle: SavedStateHandle) {
    val productionCode: String = savedStateHandle[PRODUCTION_CODE] ?: "0"
    companion object{
        const val PRODUCTION_CODE = "productionCode"
    }
}