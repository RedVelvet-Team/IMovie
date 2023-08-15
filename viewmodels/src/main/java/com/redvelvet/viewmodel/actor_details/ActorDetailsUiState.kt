package com.redvelvet.viewmodel.actor_details

import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class ActorDetailsUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val id: Int = 0,
    val name: String = "",
    val imageUrl: String = "",
    val knownForDepartment: String = "",
    val birthDate: String = "",
    val birthLocation: String = "",
    val knownAs: String = "",
    val knownFor: List<KnownForUiState> = emptyList(),
    val biography: String = ""
): BaseUiState

data class KnownForUiState(
    val id: Int = 0,
    val mediaType: String = "",
    val imageUrl: String = "",
    val name: String = ""
)

fun CombinedResult.toKnownForUiState() = KnownForUiState(
    id = this.id,
    mediaType = this.mediaType,
    imageUrl = this.imageUrl,
    name = this.name
)
