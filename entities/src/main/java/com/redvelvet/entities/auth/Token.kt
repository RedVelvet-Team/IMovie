package com.redvelvet.entities.auth

data class Token(
    val expiresAt: String? = "",
    val requestToken: String? = "",
    val success: Boolean? = false,
)
