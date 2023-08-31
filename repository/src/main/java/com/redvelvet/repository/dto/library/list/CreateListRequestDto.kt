package com.redvelvet.repository.dto.library.list

import com.google.gson.annotations.SerializedName

data class CreateListRequestDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String = "custom user list",
    @SerializedName("language")
    val language: String = "en"
)