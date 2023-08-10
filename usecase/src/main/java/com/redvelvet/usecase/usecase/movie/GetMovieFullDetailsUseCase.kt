package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieFullDetails
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetMovieFullDetailsUseCase @Inject private constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getMovieImagesUseCase: GetMovieImagesUseCase,
    private val getMovieKeyWordUseCase: GetMovieKeyWordUseCase,
    private val getMovieRecommendationUseCase: GetMovieRecommendationUseCase,
    private val getMovieReviewUseCase: GetMovieReviewUseCase,
    private val getMovieSimilarUseCase: GetMovieSimilarUseCase,
    private val getMovieTopCastUseCase: GetMovieTopCastUseCase
) {
    suspend operator fun invoke(movieId: Int): MovieFullDetails =
        coroutineScope {
            val details = getMovieDetailsUseCase(movieId)
            val images = getMovieImagesUseCase(movieId)
            val keyWords = getMovieKeyWordUseCase(movieId)
            val recommendations = getMovieRecommendationUseCase(movieId)
            val reviews = getMovieReviewUseCase(movieId)
            val similar = getMovieSimilarUseCase(movieId)
            val topCast = getMovieTopCastUseCase(movieId)

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
}

