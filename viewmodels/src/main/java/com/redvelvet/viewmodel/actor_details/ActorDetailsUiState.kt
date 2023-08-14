package com.redvelvet.viewmodel.actor_details

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class ActorDetailsUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val name: String = "",
    val gender: String = "",
    val bornDate: String = "",
    val bornLocation: String = "",
    val knownAs: String = "",
    val knownFor: List<KnownForUiState> = emptyList(),
    val biography: String = ""
): BaseUiState

data class KnownForUiState(
    val imageUrl: String = "",
    val name: String = ""
)