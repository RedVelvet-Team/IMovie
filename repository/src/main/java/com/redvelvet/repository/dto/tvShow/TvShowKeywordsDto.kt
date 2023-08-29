package com.redvelvet.repository.dto.tvShow


import com.google.gson.annotations.SerializedName
import com.redvelvet.repository.dto.schema.ItemKeyword

data class TvShowKeywordsDto(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("results")
    val results: List<ItemKeyword?>? = null
)