package com.redvelvet.repository.dto

import com.google.gson.annotations.SerializedName
import com.redvelvet.repository.dto.search.CombinedResultDto

data class ActorKnownForDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("cast")
    val result: List<CombinedResultDto>,
    @SerializedName("crew")
    val crew: List<CombinedResultDto>
)
