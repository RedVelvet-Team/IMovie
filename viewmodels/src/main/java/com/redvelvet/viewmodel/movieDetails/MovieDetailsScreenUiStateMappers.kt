package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.viewmodel.utils.Constants


fun MovieFullDetails.toMovieFullDetailsScreenUiState(): MovieDetailsScreenUiState.MovieFullDetailsUiState {
    return MovieDetailsScreenUiState.MovieFullDetailsUiState(
        details = this.details.toMovieDetailsUiState(),
        topCast = this.topCast.cast.toTopCastUiState(),
        keyWords = this.keyWords.keywords.toMovieKeyWordsUiState(),
        similar = this.similar.result.toMoviesUiState(),
        images = this.images.posters.toMovieImagesUiState(),
        reviews = this.reviews.results.toMovieReviewsUiState(),
        recommendations = this.recommendations.results.toMovieRecommendationsUiState(),
    )


}

fun MovieDetails.toMovieDetailsUiState(): MovieDetailsScreenUiState.MovieDetailsUiState {
    return MovieDetailsScreenUiState.MovieDetailsUiState(
        genres = this.genres.map { it.name },
        homepage = this.homepage,
        id = this.id,
        originalTitle = this.originalTitle,
        overview = this.overview,
        posterPath = Constants.BASE_IMAGE_URL + this.posterPath,
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
            castImage = Constants.BASE_IMAGE_URL + it.profilePath
        )
    }

}

fun List<MovieSimilar.Result>.toMoviesUiState(): List<MovieDetailsScreenUiState.MovieSimilarUiState> {
    return this.map {
        MovieDetailsScreenUiState.MovieSimilarUiState(
            mediaId = it.id,
            mediaName = it.title,
            mediaImage = Constants.BASE_IMAGE_URL + it.posterPath,
        )
    }

}

fun List<MovieImages.Poster>.toMovieImagesUiState(): List<MovieDetailsScreenUiState.MovieImagesUiState> {
    return this.map {
        MovieDetailsScreenUiState.MovieImagesUiState(
            mediaImage = Constants.BASE_IMAGE_URL + it.filePath,
        )
    }

}

fun List<MovieReviews.Result>.toMovieReviewsUiState(): List<MovieDetailsScreenUiState.MovieReviewsUiState> {
    return this.map {
        MovieDetailsScreenUiState.MovieReviewsUiState(
            reviewId = it.id,
            reviewAuthor = it.username,
            reviewDescription = it.content,
            reviewDate = it.createdAt,
            reviewStars = it.rating,
        )
    }

}

fun List<MovieKeyWords.Keyword>.toMovieKeyWordsUiState(): List<String> {
    return this.map {
        it.name
    }

}

fun List<MovieRecommendations.Result>.toMovieRecommendationsUiState(): List<MovieDetailsScreenUiState.MovieRecommendationsUiState> {
    return this.map {
        MovieDetailsScreenUiState.MovieRecommendationsUiState(
            mediaId = it.id,
            mediaName = it.title,
            mediaImage = Constants.BASE_IMAGE_URL + it.posterPath,
        )
    }

}