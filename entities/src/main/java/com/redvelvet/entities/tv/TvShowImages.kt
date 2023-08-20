package com.redvelvet.entities.tv

data class TvShowImages(
    val posters: List<Poster> = emptyList()
)

data class Poster(
    val filePath: String = ""
)