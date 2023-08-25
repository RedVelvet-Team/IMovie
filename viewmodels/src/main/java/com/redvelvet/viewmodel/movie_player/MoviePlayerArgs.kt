package com.redvelvet.viewmodel.movie_player

import androidx.lifecycle.SavedStateHandle

class MoviePlayerArgs (savedStateHandle: SavedStateHandle) {
    val videoUrl: String = savedStateHandle[VIDEO_URL] ?: ""

    companion object{
        const val VIDEO_URL= "video_url"
    }
}