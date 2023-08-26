package com.redvelvet.repository.dto.listAndFavorites

import com.google.gson.annotations.SerializedName

data class UserListDto(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
)
