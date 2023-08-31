package com.redvelvet.repository.dto.request

import com.google.gson.annotations.SerializedName

class AddToWatchListDto(
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("media_id")
    val mediaId: Int,
    @SerializedName("watchlist")
    val watchlist: Boolean
)