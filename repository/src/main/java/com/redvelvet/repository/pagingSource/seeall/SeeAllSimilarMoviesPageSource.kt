package com.redvelvet.repository.pagingSource.seeall

import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.pagingSource.BasePagingSource
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class SeeAllSimilarMoviesPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    val id: Int
) : BasePagingSource<MovieDetailsDTO>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<MovieDetailsDTO> {
        return remoteDataSource.seeAllSimilarMovie(page = page, id = id)
    }
}