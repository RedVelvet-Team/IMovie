package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieTopCast


fun MovieFullDetails.toMovieFullDetailsScreenUiState(): MovieDetailsScreenUiState.MovieFullDetailsUiState {
    return MovieDetailsScreenUiState.MovieFullDetailsUiState(
        details = this.details.toMovieDetailsUiState(),
        topCast = this.topCast.cast.toTopCastUiState(),
        keyWords = this.keyWords.keywords.toMovieKeyWordsUiState(),
        images = MovieDetailsScreenUiState.MovieImagesUiState(),
        recommendations = MovieDetailsScreenUiState.MovieRecommendationsUiState(),
        reviews = MovieDetailsScreenUiState.MovieReviewsUiState(),
        similar = MovieDetailsScreenUiState.MovieSimilarUiState(),
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
        spokenLanguages = this.spokenLanguages.joinToString(", ") { it.englishName },
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        voteAverage = this.voteAverage,
    )
}

fun List<MovieTopCast.Cast>.toTopCastUiState(): List<MovieDetailsScreenUiState.MovieTopCastUiState> {
    return this.map {
        MovieDetailsScreenUiState.MovieTopCastUiState(
            castId = it.id,
            castName = it.name,
            castImage = "https://image.tmdb.org/t/p/w500" + it.profilePath
        )
    }

}

fun List<MovieKeyWords.Keyword>.toMovieKeyWordsUiState(): List<MovieDetailsScreenUiState.MovieKeyWordsUiState> {
    return this.map {
        MovieDetailsScreenUiState.MovieKeyWordsUiState(
            keywordId = it.id,
            keywordString = it.name,
        )
    }

}