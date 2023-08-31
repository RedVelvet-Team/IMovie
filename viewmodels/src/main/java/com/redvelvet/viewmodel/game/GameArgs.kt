package com.redvelvet.viewmodel.game

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.viewmodel.utils.MediaType

class GameArgs(savedStateHandle: SavedStateHandle) {
    val media: String = savedStateHandle[MEDIA] ?: MediaType.MOVIE.name

    companion object {
        const val MEDIA = "category"
    }
}