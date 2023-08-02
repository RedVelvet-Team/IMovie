package com.redvelvet.repository.dto.auth.response

import com.google.gson.annotations.SerializedName

data class SessionDto(
    @SerializedName("session_id")
    val sessionId: String?,
    val success: Boolean?
)