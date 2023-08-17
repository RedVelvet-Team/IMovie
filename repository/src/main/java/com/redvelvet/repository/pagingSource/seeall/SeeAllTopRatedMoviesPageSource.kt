package com.redvelvet.repository.pagingSource.seeall

import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.pagingSource.BasePagingSource
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class SeeAllTopRatedMoviesPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
) : BasePagingSource<MovieDetailsDTO>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<MovieDetailsDTO> {
        return remoteDataSource.seeAllTopRatedMovie(page = page)
    }

}