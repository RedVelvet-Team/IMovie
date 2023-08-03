package com.redvelvet.entities.search

data class SearchResult(
    val id: Int?,
    val mediaType: String?,
    val name: String?,
    val originalName: String?,
    val language: String?,
    val posterPath: String?,
    val profilePath: String?,
    val releaseDate: String?,
    val firstAirDate: String?,
){
    fun getDate() = if (firstAirDate.isNullOrEmpty()) releaseDate else firstAirDate
    fun getMediaName() = if (name.isNullOrEmpty()) originalName else name
    fun getImage() = if (posterPath.isNullOrEmpty()) profilePath else posterPath
}