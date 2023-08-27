package com.redvelvet.entities.library

data class CreateList(
    val status_code: Long?,
    val status_message: String?,
    val success: Boolean?,
    val list_id : Long,
)
