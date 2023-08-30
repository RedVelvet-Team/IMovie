package com.redvelvet.repository.dto

import com.google.gson.annotations.SerializedName

data class GenresDto(
    @SerializedName("genres")
    val genres: List<GenreDto>
) {
    data class GenreDto(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?
    )
}