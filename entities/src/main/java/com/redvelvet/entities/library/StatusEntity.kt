package com.redvelvet.entities.library

data class StatusEntity(
    val statusCode: Int,
    val statusMessage: String,
    val success: Boolean
)
