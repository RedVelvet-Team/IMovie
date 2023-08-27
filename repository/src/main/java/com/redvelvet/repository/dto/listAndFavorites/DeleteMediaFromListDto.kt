package com.redvelvet.repository.dto.listAndFavorites

import com.google.gson.annotations.SerializedName

data class DeleteMediaFromListDto(
    @SerializedName("media_id")
    val mediaId: Int? = null
)