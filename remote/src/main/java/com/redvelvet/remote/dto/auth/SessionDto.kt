package com.redvelvet.remote.dto.auth

import com.google.gson.annotations.SerializedName

data class SessionDto(
    @SerializedName("session_id")
    val sessionId: String?,
    @SerializedName("success")
    val success: Boolean?
)