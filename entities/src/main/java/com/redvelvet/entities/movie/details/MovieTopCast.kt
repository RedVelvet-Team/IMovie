package com.redvelvet.entities.movie.details

data class MovieTopCast(
    val id: Int,
    val cast: List<Cast>,
) {
    data class Cast(
        val id: Int,
        val name: String,
        val profilePath: String,
    )
}
