package com.redvelvet.repository.pagingSource

import com.redvelvet.entities.tv.TvShow
import com.redvelvet.repository.mapper.toTvShow
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class TvShowSearchPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    private val query: String
) : BasePagingSource<TvShow>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<TvShow> {
        return remoteDataSource.searchTvShows(query = query, page = page)
            .map { it.toTvShow() }
    }
}