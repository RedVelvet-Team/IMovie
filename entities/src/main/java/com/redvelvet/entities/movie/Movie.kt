package com.redvelvet.entities.movie

data class Movie(
    val id: Int,
    val name: String,
    val movieImageUrl: String,
    val country: String,
    val releaseDate: String,
)