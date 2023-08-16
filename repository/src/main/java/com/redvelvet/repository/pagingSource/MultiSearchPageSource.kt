package com.redvelvet.repository.pagingSource

import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.mapper.toSearchResult
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class MultiSearchPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    private val query: String
) : BasePagingSource<SearchResult>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<SearchResult> {
        return remoteDataSource.multiSearch(query = query, page = page).map { it.toSearchResult() }
    }
}