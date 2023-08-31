package com.redvelvet.repository.dto.schema

import com.google.gson.annotations.SerializedName

data class AuthorDetails(
    @SerializedName("avatar_path")
    val avatarPath: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("username")
    val username: String?
)