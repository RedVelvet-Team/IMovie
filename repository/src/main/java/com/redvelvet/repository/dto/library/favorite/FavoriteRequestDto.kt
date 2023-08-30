package com.redvelvet.repository.dto.library.favorite

import com.google.gson.annotations.SerializedName

data class FavoriteRequestDto(
    @SerializedName("favorite")
    val favorite: Boolean? = null,
    @SerializedName("media_id")
    val mediaId: Int? = null,
    @SerializedName("media_type")
    val mediaType: String? = null
)