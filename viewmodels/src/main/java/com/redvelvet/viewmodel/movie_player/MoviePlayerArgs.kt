package com.redvelvet.viewmodel.movie_player

import androidx.lifecycle.SavedStateHandle

class MoviePlayerArgs(savedStateHandle: SavedStateHandle) {
    val roomId: String = savedStateHandle[ROOM_ID] ?: ""

    companion object {
        const val ROOM_ID = "room_id"
    }
}