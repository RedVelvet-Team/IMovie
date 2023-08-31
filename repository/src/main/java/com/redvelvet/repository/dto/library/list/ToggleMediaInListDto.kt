package com.redvelvet.repository.dto.library.list

import com.google.gson.annotations.SerializedName

data class ToggleMediaInListDto(
    @SerializedName("media_id")
    val mediaId: Int? = null,
)
