package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetMoviesCategories @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    suspend operator fun invoke(): List<List<MovieDetails>> {
        return coroutineScope {
            val popularMovies = async { getPopularMovies() }
            val upComingMovies = async { getUpComingMovies() }
            val topRatedMovies = async { getTopRatedMovies() }
            val nowPlayingMovies = async { getNowPlayingMovies() }
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