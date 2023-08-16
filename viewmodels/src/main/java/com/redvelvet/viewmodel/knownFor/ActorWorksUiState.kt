package com.redvelvet.viewmodel.knownFor

import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class ActorWorksUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val title: String = "Known For",
    val knownFor: List<KnownForUiState> = emptyList(),
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
