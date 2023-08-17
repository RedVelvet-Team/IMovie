package com.redvelvet.repository.pagingSource.seealltv

import com.redvelvet.repository.dto.tvShow.TvShowDto
import com.redvelvet.repository.pagingSource.BasePagingSource
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class SeeAllOnTheAirTvPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource
) : BasePagingSource<TvShowDto>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<TvShowDto> {
        return remoteDataSource.seeAllAiringTodayTv(page)
    }
}