package com.redvelvet.entities.library

data class LibraryMovie(
    val backdropPath: String,
    val id: Int,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val title: String
)
