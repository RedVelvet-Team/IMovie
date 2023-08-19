package com.redvelvet.viewmodel.movie_player

import androidx.lifecycle.SavedStateHandle

class MoviePlayerArgs(savedStateHandle: SavedStateHandle) {
    val productionCode: String = savedStateHandle[PRODUCTION_CODE] ?: "0"
    companion object{
        const val PRODUCTION_CODE = "productionCode"
    }
}