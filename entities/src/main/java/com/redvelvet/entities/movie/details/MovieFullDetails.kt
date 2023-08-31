package com.redvelvet.entities.movie.details

import com.redvelvet.entities.library.WatchListMedia

data class MovieFullDetails(
    val details: MovieDetails,
    val images: MovieImages,
    val keyWords: MovieKeyWords,
    val recommendations: MovieRecommendations,
    val reviews: MovieReviews,
    val similar: MovieSimilar,
    val topCast: MovieTopCast,
    val moviesFavorites: WatchListMedia,
    val moviesWatchlist: WatchListMedia,
    val ratedMovie: WatchListMedia,
)
