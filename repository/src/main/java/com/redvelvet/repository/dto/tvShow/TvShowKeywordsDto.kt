package com.redvelvet.repository.dto.tvShow


import com.google.gson.annotations.SerializedName

data class TvShowKeywordsDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("results")
    val results: List<TvShowResultDto?>? = null
)

data class TvShowResultDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null
)