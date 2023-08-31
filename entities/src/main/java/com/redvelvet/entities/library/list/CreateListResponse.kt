package com.redvelvet.entities.library.list


data class CreateListResponse(
    val listId: Int,
    val statusCode: Int,
    val statusMessage: String,
    val success: Boolean
)