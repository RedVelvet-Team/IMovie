package com.redvelvet.entities.movie.details

data class MovieDetails(
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val productionCountries: List<ProductionCountry>,
    val releaseDate: String,
    val revenue: Int,
    val runtime: String,
    val spokenLanguages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
) {
    data class Genre(
        val id: Int,
        val name: String
    )

    data class ProductionCountry(
        val iso31661: String,
        val name: String
    )

    data class SpokenLanguage(
        val englishName: String,
    )
}