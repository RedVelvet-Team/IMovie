package com.redvelvet.entities.library.list


data class CreatedLists(
    val page: Int,
    val results: List<Result>,
) {
    data class Result(
        val favoriteCount: Int,
        val id: Int,
        val itemCount: Int,
        val listType: String,
        val name: String,
        val posterPath: String
    )
}