package com.redvelvet.entities.user

data class Token(
    val expiresAt: String?,
    val requestToken: String?,
    val success: Boolean?
)
