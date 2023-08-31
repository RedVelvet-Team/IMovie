package com.redvelvet.repository.dto.request

import com.google.gson.annotations.SerializedName

class AddToFavorite(
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("media_id")
    val mediaId: Int,
    @SerializedName("favorite")
    val favorite: Boolean
)