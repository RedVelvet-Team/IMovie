package com.redvelvet.repository.dto.detailsRequests

import com.google.gson.annotations.SerializedName

data class AddToWatchListRequest(
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("media_id")
    val mediaId: Int?,
    @SerializedName("watchlist")
    val watchlist: Boolean?,
)