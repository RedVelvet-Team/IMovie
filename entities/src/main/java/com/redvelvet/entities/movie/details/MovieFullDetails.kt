package com.redvelvet.entities.movie.details

import com.redvelvet.entities.library.LibraryMovie

data class MovieFullDetails(
    val details: MovieDetails,
    val images: MovieImages,
    val keyWords: MovieKeyWords,
    val recommendations: MovieRecommendations,
    val reviews: MovieReviews,
    val similar: MovieSimilar,
    val topCast: MovieTopCast,
    val moviesFavorites: List<LibraryMovie>,
    val moviesWatchlist: List<LibraryMovie>,
    val ratedMovie: List<LibraryMovie>,
)
