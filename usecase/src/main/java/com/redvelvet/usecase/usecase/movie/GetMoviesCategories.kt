package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetMoviesCategories @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    private val limit = 10
    suspend operator fun invoke(): List<List<MovieDetails>> {
        return coroutineScope {
            val popularMovies = async { getPopularMovies().take(limit) }
            val upComingMovies = async { getUpComingMovies().take(limit) }
            val topRatedMovies = async { getTopRatedMovies().take(limit)}
            val nowPlayingMovies = async { getNowPlayingMovies().take(limit) }
            listOf(
                popularMovies.await(),
                upComingMovies.await(),
                topRatedMovies.await(),
                nowPlayingMovies.await()
            )
        }
    }

     suspend fun getPopularMovies() = movieRepository.getPopularMovies()
     suspend fun getUpComingMovies() = movieRepository.getUpComingMovies()
     suspend fun getTopRatedMovies() = movieRepository.getTopRatedMovies()
     suspend fun getNowPlayingMovies() = movieRepository.getNowPlayingMovies()
}