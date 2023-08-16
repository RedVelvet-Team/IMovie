package com.redvelvet.viewmodel.knownFor

import androidx.lifecycle.SavedStateHandle

class KnownForArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID] ?: "0"

    companion object{
        const val ID = "id"
    }
}