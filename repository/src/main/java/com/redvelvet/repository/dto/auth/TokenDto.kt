package com.redvelvet.repository.dto.auth

import com.google.gson.annotations.SerializedName

data class TokenDto(
    @SerializedName("expires_at")
    val expiresAt: String?,
    @SerializedName("request_token")
    val requestToken: String?,
    val success: Boolean?
)