package com.redvelvet.entities.library

data class StatusEntity(
    val success: Boolean,
    val statusCode: Int,
    val statusMessage: String
)