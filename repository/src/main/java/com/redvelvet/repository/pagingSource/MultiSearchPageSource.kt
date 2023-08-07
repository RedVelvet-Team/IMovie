package com.redvelvet.repository.pagingSource

import android.util.Log
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.mapper.toEntity
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class MultiSearchPageSource @Inject constructor(
    remoteDataSource: RemoteDataSource,
    private val query: String
) : BasePagingSource<SearchResult>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<SearchResult> {
        val response = remoteDataSource.multiSearch(query = query, page = page).map { it.toEntity() }
        Log.d("Ibrahim", " $response")
        return response
    }
}