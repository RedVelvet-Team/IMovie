package com.redvelvet.repository.dto.auth.response

import com.google.gson.annotations.SerializedName
import com.redvelvet.entities.auth.Token

data class TokenDto(
    @SerializedName("expires_at")
    val expiresAt: String?,
    @SerializedName("request_token")
    val requestToken: String?,
    val success: Boolean?
)

