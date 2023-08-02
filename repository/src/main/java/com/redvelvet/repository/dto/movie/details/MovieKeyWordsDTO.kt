package com.redvelvet.repository.dto.movie.details


import com.google.gson.annotations.SerializedName

data class MovieKeyWordsDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("keywords")
    val keywords: List<Keyword>
) {
    data class Keyword(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String
    )
}