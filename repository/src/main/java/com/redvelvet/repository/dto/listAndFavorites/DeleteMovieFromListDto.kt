package com.redvelvet.repository.dto.listAndFavorites

import com.google.gson.annotations.SerializedName

data class DeleteMovieFromListDto(
    @SerializedName("media_id")
    val mediaId: Int? = null
)