package com.redvelvet.repository.dto.listAndFavorites

import com.google.gson.annotations.SerializedName

data class CreateUserListDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description:String? = "",
    @SerializedName("language")
    val lang:String = "en"
)