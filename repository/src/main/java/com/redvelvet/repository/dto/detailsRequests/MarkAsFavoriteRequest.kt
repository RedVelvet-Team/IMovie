package com.redvelvet.repository.dto.detailsRequests

import com.google.gson.annotations.SerializedName

data class MarkAsFavoriteRequest(
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("media_id")
    val mediaId: Int?,
    @SerializedName("favorite")
    val favorite: Boolean?,
)