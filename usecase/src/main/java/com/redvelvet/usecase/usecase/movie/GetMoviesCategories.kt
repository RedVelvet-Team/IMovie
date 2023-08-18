package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetMoviesCategories @Inject constructor(
    private val movieRepository: MovieRepository,
) {
    private val limit = 10
    suspend operator fun invoke(): List<List<Movie>> {
        return coroutineScope {
            val popularMovies = async { getPopularMovies() }
            val upComingMovies = async { getUpComingMovies() }
            val nowPlayingMovies = async { getNowPlayingMovies()}
            val topRatedMovies = async { getTopRatedMovies() }
            listOf(
                popularMovies.await(),
                upComingMovies.await(),
                nowPlayingMovies.await(),
                topRatedMovies.await()
            )
        }
    }

     suspend fun getPopularMovies() = movieRepository.getPopularMovies()
     suspend fun getUpComingMovies() = movieRepository.getUpComingMovies()
     suspend fun getTopRatedMovies() = movieRepository.getTopRatedMovies()
     suspend fun getNowPlayingMovies() = movieRepository.getNowPlayingMovies()
}