package com.redvelvet.entities.search

data class SearchResult(
    val id: Int,
    val mediaType: String,
    val name: String,
    val originalName: String,
    val language: String,
    val posterPath: String,
    val profilePath: String,
    val releaseDate: String,
    val firstAirDate: String,
)

data class CombinedResult(
    val id: Int,
    val mediaType: String,
    val name: String,
    val language: String,
    val imageUrl: String,
    val releaseDate: String,
)