package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieFullDetails


fun MovieFullDetails.toMovieFullDetailsScreenUiState(): MovieDetailsScreenUiState.MovieFullDetailsUiState {
    return MovieDetailsScreenUiState.MovieFullDetailsUiState(
        details = this.details.toMovieDetailsUiState(),
        images = MovieDetailsScreenUiState.MovieImagesUiState(),
        keyWords = MovieDetailsScreenUiState.MovieKeyWordsUiState(),
        recommendations = MovieDetailsScreenUiState.MovieRecommendationsUiState(),
        reviews = MovieDetailsScreenUiState.MovieReviewsUiState(),
        similar = MovieDetailsScreenUiState.MovieSimilarUiState(),
        topCast = MovieDetailsScreenUiState.MovieTopCastUiState()
    )

}

fun MovieDetails.toMovieDetailsUiState(): MovieDetailsScreenUiState.MovieDetailsUiState {
    return MovieDetailsScreenUiState.MovieDetailsUiState(
        genres = this.genres.map { it.name },
        homepage = this.homepage,
        id = this.id,
        originalTitle = this.originalTitle,
        overview = this.overview,
        posterPath = "https://image.tmdb.org/t/p/w500" + this.posterPath,
        productionCountries = this.productionCountries.map { it.name },
        releaseDate = this.releaseDate,
        revenue = this.revenue,
        runtime = this.runtime,
        spokenLanguages = this.spokenLanguages.map { it.englishName },
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
    )
}