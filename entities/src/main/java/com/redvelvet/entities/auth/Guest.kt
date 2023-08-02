package com.redvelvet.entities.auth


data class Guest(
    val expiresAt: String? = "",
    val guestSessionId: String? = "",
    val success: Boolean? = false
)
