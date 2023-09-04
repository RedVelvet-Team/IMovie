package com.redvelvet.usecase.usecase.movie

import com.redvelvet.entities.movie.Movie
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetMoviesCategories @Inject constructor(
    private val movieRepository: MovieRepository,
) {
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

    private suspend fun getPopularMovies() = movieRepository.getPopularMovies()
    private suspend fun getUpComingMovies() = movieRepository.getUpComingMovies()
    private suspend fun getTopRatedMovies() = movieRepository.getTopRatedMovies()
    private suspend fun getNowPlayingMovies() = movieRepository.getNowPlayingMovies()
}