package com.redvelvet.entities.library.list


data class CreateListRequest(
    val name: String,
    val description: String,
    val language: String
)