package com.redvelvet.repository.dto.schema

import com.google.gson.annotations.SerializedName

data class ItemKeyword(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)
