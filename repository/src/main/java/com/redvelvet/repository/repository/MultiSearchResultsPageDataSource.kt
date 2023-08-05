package com.redvelvet.repository.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.source.RemoteDataSource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MultiSearchResultsPageDataSource(
    private val remoteDataSource: RemoteDataSource,
    private val query :String
) : PagingSource<Int, MultiSearchResultDto>() {

    override fun getRefreshKey(state: PagingState<Int, MultiSearchResultDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,MultiSearchResultDto> {
        Log.v("hassan", "data is start loading")
        return try {
            val currentPage = params.key ?: 1
            val result = remoteDataSource.multiSearch(
                page = currentPage,
                query = query
            )
            Log.v("hassan", "data is end loading")
            LoadResult.Page(
                data = result,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (result.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}