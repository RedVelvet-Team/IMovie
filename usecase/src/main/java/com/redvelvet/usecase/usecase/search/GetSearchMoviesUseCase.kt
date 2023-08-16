package com.redvelvet.usecase.usecase.search

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchMoviesUseCase  @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String): Flow<PagingData<Movie>> {
        return movieRepository.searchMovie(query = query, page = null)
    }
}