package com.redvelvet.entities.movie.details

data class MovieReviews(
    val id: Int,
    val results:List<Result>
){
    data class Result(
        val id: Int,
        val name: String,
        val username: String,
        val content: String,
        val createdAt: String,
        val url: String,
        val rating: Double
    )
}
