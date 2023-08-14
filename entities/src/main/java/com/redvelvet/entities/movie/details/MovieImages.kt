package com.redvelvet.entities.movie.details

data class MovieImages (
    val backdrops: List<Backdrop>,
    val id: Int,
    val logos: List<Logo>,
    val posters: List<Poster>
) {
    data class Backdrop(
        val filePath: String
    )

    data class Logo(
        val filePath: String
    )
    data class Poster(
        val filePath: String
    )
}
