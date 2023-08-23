package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetMovieFullDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(movieId: Int): MovieFullDetails =
        coroutineScope {
            val detailsDeferred = async { getMovieDetailsById(movieId) }
            val imagesDeferred = async { getMovieImagesByID(movieId) }
            val keyWordsDeferred = async { getMovieKeyWordsByID(movieId) }
            val recommendationsDeferred = async { getMovieRecommendationsByID(movieId) }
            val reviewsDeferred = async { getMovieReviewsByID(movieId) }
            val similarDeferred = async { getMovieSimilarByID(movieId) }
            val topCastDeferred = async { getMovieTopCastByID(movieId) }

            val details = detailsDeferred.await()
            val images = imagesDeferred.await()
            val keyWords = keyWordsDeferred.await()
            val recommendations = recommendationsDeferred.await()
            val reviews = reviewsDeferred.await()
            val similar = similarDeferred.await()
            val topCast = topCastDeferred.await()

            MovieFullDetails(
                details = details,
                images = images,
                keyWords = keyWords,
                recommendations = recommendations,
                reviews = reviews,
                similar = similar,
                topCast = topCast
            )
        }

    private suspend fun getMovieDetailsById(movieId: Int): MovieDetails {
        return movieRepository.getMovieDetailsById(movieId)
    }

    suspend fun getMovieImagesByID(movieId: Int): MovieImages {
        return movieRepository.getMovieImagesByID(movieId)
    }

    private suspend fun getMovieKeyWordsByID(movieId: Int): MovieKeyWords {
        return movieRepository.getMovieKeyWordsByID(movieId)
    }

    private suspend fun getMovieRecommendationsByID(movieId: Int): MovieRecommendations {
        return movieRepository.getMovieRecommendationsByID(movieId)
    }

    suspend fun getMovieReviewsByID(movieId: Int): MovieReviews {
        return movieRepository.getMovieReviewsByID(movieId)
    }

    private suspend fun getMovieSimilarByID(movieId: Int): MovieSimilar {
        return movieRepository.getMovieSimilarByID(movieId)
    }

    suspend fun getMovieTopCastByID(movieId: Int): MovieTopCast {
        return movieRepository.getMovieTopCastByID(movieId)
    }
}

