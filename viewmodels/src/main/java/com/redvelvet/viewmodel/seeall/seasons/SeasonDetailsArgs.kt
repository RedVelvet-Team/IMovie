package com.redvelvet.viewmodel.seeall.seasons

import androidx.lifecycle.SavedStateHandle

class SeasonDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID] ?: "0"

    companion object{
        const val ID = "id"
    }
}