package com.redvelvet.repository.pagingSource.seeall

import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.pagingSource.BasePagingSource
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class SeeAllSimilarMoviesPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    val id: Int
) : BasePagingSource<MovieDto>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<MovieDto> {
        return remoteDataSource.seeAllSimilarMovie(page = page, id = id)
    }
}