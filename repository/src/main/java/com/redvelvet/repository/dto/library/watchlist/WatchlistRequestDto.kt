package com.redvelvet.repository.dto.library.watchlist

import com.google.gson.annotations.SerializedName

data class WatchlistRequestDto(
    @SerializedName("watchlist")
    val watchlist: Boolean? = null,
    @SerializedName("media_id")
    val mediaId: Int? = null,
    @SerializedName("media_type")
    val mediaType: String? = null
)