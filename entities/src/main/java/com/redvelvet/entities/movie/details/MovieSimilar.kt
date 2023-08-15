package com.redvelvet.entities.movie.details

data class MovieSimilar(
    val result: List<Result>
){
    data class Result(
        val id: Int,
        val title: String,
        val posterPath: String,
    )
}
