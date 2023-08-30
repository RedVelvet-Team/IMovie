package com.redvelvet.repository.dto.movie.details


import com.google.gson.annotations.SerializedName
import com.redvelvet.repository.dto.schema.ItemKeyword

data class MovieKeyWordsDTO(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("keywords")
    val keywords: List<ItemKeyword>
)