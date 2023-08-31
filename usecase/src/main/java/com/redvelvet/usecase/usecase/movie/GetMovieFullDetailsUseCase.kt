package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.library.WatchListMedia
import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.entities.movie.details.MovieImages
import com.redvelvet.entities.movie.details.MovieKeyWords
import com.redvelvet.entities.movie.details.MovieRecommendations
import com.redvelvet.entities.movie.details.MovieReviews
import com.redvelvet.entities.movie.details.MovieSimilar
import com.redvelvet.entities.movie.details.MovieTopCast
import com.redvelvet.usecase.repository.MovieRepository
import com.redvelvet.usecase.usecase.detailsActions.HandleItemCheckUsecase
import javax.inject.Inject

class GetMovieFullDetailsUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val getActionsLists: HandleItemCheckUsecase,
) {
    suspend operator fun invoke(movieId: Int): MovieFullDetails {
        val details = getMovieDetailsById(movieId)
        val images = getMovieImagesByID(movieId)
        val keyWords = getMovieKeyWordsByID(movieId)
        val recommendations = getMovieRecommendationsByID(movieId)
        val reviews = getReviewsByID(movieId)
        val similar = getMovieSimilarByID(movieId)
        val topCast = getMovieTopCastByID(movieId)
        val moviesFavorites = getMoviesFavorites()
        val moviesWatchlist = getMoviesWatchlist()
        val ratedMovies = getRatedMovie()

        return MovieFullDetails(
            details = details,
            images = images,
            keyWords = keyWords,
            recommendations = recommendations,
            reviews = reviews,
            similar = similar,
            topCast = topCast,
            moviesFavorites = moviesFavorites,
            moviesWatchlist = moviesWatchlist,
            ratedMovie = ratedMovies,
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

    suspend fun getReviewsByID(movieId: Int): MovieReviews {
        return movieRepository.getMovieReviewsByID(movieId)
    }

    private suspend fun getMovieSimilarByID(movieId: Int): MovieSimilar {
        return movieRepository.getMovieSimilarByID(movieId)
    }

    suspend fun getMovieTopCastByID(movieId: Int): MovieTopCast {
        return movieRepository.getMovieTopCastByID(movieId)
    }

    suspend fun getMoviesFavorites(): WatchListMedia {
        return getActionsLists.getMovieFavorites();
    }

    suspend fun getMoviesWatchlist(): WatchListMedia {
        return getActionsLists.getMovieWatchList();
    }

    suspend fun getRatedMovie(): WatchListMedia {
        return getActionsLists.getRatedMovie();
    }

}

