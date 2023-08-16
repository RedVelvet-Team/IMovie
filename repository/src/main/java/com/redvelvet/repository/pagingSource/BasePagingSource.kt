package com.redvelvet.repository.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.redvelvet.repository.source.RemoteDataSource
import java.io.IOException

abstract class BasePagingSource<Value : Any> (
    protected val remoteDataSource: RemoteDataSource
) : PagingSource<Int, Value>() {

    protected abstract suspend fun fetchData(page: Int): List<Value>

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Value> {
        val currentPage = params.key ?: 1
        return try {
            val response = fetchData(currentPage)
            val nextKey = (currentPage + 1).takeIf { response.lastIndex >= currentPage }
            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Value>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}