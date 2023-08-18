package com.redvelvet.repository.pagingSource.seealltv

import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.pagingSource.BasePagingSource
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class SeeAllRecommendedTvShowsPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    val id: Int
) : BasePagingSource<TvShowDto>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<TvShowDto> {
        return remoteDataSource.seeAllRecommendedTv(page = page, id = id)
    }
}