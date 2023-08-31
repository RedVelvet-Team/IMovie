package com.redvelvet.entities.library.list

data class ListDetails(
    val createdBy: String?,
    val description: String?,
    val favoriteCount: Int?,
    val id: String?,
    val items: List<Any>,
    val itemCount: Int?,
    val iso6391: String?,
    val name: String?,
    val posterPath: String?
)