package com.redvelvet.entities.search

data class SearchResult(
    val id: Int?,
    val mediaType: String?,
    val name: String?,
    val originCountry: String?,
    val posterPath: String?,
    val releaseDate: String?
)