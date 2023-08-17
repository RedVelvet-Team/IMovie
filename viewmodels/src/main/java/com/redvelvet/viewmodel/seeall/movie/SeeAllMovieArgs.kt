package com.redvelvet.viewmodel.seeall.movie

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.viewmodel.utils.SeeAllMovie

class SeeAllMovieArgs(savedStateHandle: SavedStateHandle) {
    val id: String? = savedStateHandle[ID]
    val type: String = savedStateHandle[TYPE] ?: SeeAllMovie.POPULAR.name

    companion object{
        const val ID = "id"
        const val TYPE = "type"
    }
}