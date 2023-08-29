package com.redvelvet.repository.dto.schema

import com.google.gson.annotations.SerializedName

data class ImagesDto(
    @SerializedName("backdrops")
    val backdrops: List<ItemBackdrop>,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("logos")
    val logos: List<ItemLogo>,
    @SerializedName("posters")
    val posters: List<ItemPoster>
)
