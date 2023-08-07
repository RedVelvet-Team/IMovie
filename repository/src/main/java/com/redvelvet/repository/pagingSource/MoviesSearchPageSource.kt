package com.redvelvet.repository.pagingSource

import com.redvelvet.entities.movie.Movie
import com.redvelvet.repository.mapper.toMovieEntity
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class MoviesSearchPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    private val query: String
) : BasePagingSource<Movie>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<Movie> {
        return remoteDataSource.searchMovie(query = query, page = page).map { it.toMovieEntity() }
    }
}