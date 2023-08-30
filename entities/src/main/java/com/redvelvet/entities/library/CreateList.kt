package com.redvelvet.entities.library

data class CreateList(
    val statusCode: Int?,
    val statusMessage: String?,
    val success: Boolean?,
    val listId: Int,
)
