package com.redvelvet.viewmodel.actor_details

import androidx.lifecycle.SavedStateHandle

class ActorDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID] ?: "0"

    companion object{
        const val ID = "id"
    }
}