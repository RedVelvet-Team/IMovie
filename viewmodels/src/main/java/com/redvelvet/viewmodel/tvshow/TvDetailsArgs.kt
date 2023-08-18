package com.redvelvet.viewmodel.tvshow

import androidx.lifecycle.SavedStateHandle

class TvDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID] ?: "0"

    companion object {
        const val ID = "id"
    }
}