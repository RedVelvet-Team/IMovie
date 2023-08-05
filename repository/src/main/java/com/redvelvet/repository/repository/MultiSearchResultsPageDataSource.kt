package com.redvelvet.repository.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.source.RemoteDataSource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MultiSearchResultsPageDataSource @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
     private val query :String
) : PagingSource<Int, List<MultiSearchResultDto>>() {

    override fun getRefreshKey(state: PagingState<Int, List<MultiSearchResultDto>>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, List<MultiSearchResultDto>> {
        return try {
            val currentPage = params.key ?: 1
            val result = remoteDataSource.multiSearch(
                page = currentPage,
                query = query
            )
            val results = listOf(result)
            LoadResult.Page(
                data = results,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (results.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}