package com.redvelvet.repository.dto.listAndFavorites

import com.google.gson.annotations.SerializedName

data class AddMediaToListDto(
    @SerializedName("media_id")
    val mediaId:Int? = null,
    @SerializedName("media_type")
    val mediaType:String = "tv"
)
