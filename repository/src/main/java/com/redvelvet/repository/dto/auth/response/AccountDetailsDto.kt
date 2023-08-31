package com.redvelvet.repository.dto.auth.response

import com.google.gson.annotations.SerializedName

data class AccountDetailsDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String
)