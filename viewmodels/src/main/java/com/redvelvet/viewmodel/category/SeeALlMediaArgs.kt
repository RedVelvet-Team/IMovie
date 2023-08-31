package com.redvelvet.viewmodel.category

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.viewmodel.utils.MediaType

class SeeALlMediaArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID] ?: "0"
    val media: String = savedStateHandle[MEDIA] ?: MediaType.MOVIE.name
    val title: String = savedStateHandle[TITLE] ?: ""

    companion object {
        const val ID = "id"
        const val MEDIA = "category"
        const val TITLE = "title"
    }
}