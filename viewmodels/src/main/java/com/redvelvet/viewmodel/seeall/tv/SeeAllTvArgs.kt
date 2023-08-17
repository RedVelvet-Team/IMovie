package com.redvelvet.viewmodel.seeall.tv

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.viewmodel.utils.SeeAllTvShows

class SeeAllTvArgs(savedStateHandle: SavedStateHandle) {
    val id: String? = savedStateHandle[ID]
    val type: String = savedStateHandle[TYPE] ?: SeeAllTvShows.POPULAR.name

    companion object{
        const val ID = "id"
        const val TYPE = "type"
    }
}