package com.redvelvet.repository.dto.auth

import com.google.gson.annotations.SerializedName

data class GuestSessionDto(
    @SerializedName("expires_at")
    val expiresAt: String?,
    @SerializedName("guest_session_id")
    val guestSessionId: String?,
    val success: Boolean?
)