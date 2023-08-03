package com.redvelvet.entities.auth


data class Session(
    val sessionId: String? = "",
    val success: Boolean? = false
)