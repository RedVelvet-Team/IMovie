package com.redvelvet.repository.pagingSource.category

import com.redvelvet.repository.dto.movie.details.MovieDetailsDTO
import com.redvelvet.repository.pagingSource.BasePagingSource
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class MovieCategoryByIdPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    val id: Int
) : BasePagingSource<MovieDetailsDTO>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<MovieDetailsDTO> {
        return remoteDataSource.getMovieCategoryById(page, id)
    }
}