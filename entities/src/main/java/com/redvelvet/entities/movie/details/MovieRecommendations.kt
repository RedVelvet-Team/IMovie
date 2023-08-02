package com.redvelvet.entities.movie.details

data class MovieRecommendations(
    val results: List<Result>,
) {
    data class Result(
        val id: Int,
        val title: String,
        val posterPath: String,
    )
}
