package com.redvelvet.entities.movie.details

data class MovieFullDetails(
    val details:MovieDetails,
    val images: MovieImages,
    val keyWords: MovieKeyWords,
    val recommendations: MovieRecommendations,
    val reviews: MovieReviews,
    val similar: MovieSimilar,
    val topCast: MovieTopCast
)
