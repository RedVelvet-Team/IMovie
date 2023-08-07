package com.redvelvet.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.mapper.toSearchResult
import com.redvelvet.repository.pagingSource.MultiSearchPageSource
import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource,
) : MovieRepository, BaseRepository() {

    //region search
    override fun multiSearch(query: String, page: Int?): Flow<PagingData<SearchResult>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { MultiSearchPageSource(remoteDataSource, query) }
        ).flow
    }


    override suspend fun searchPeople(query: String, page: Int?): List<SearchResult> {
        return wrapRemoteResponse {
            remoteDataSource.searchPeople(query, page).map { it.toSearchResult() }
        }
    }

    override suspend fun searchMovie(query: String, page: Int?): List<SearchResult> {
        return wrapRemoteResponse {
            remoteDataSource.searchMovie(query, page).map { it.toSearchResult() }
        }
    }

    override suspend fun searchTvShows(query: String, page: Int?): List<SearchResult> {
        return wrapRemoteResponse {
            remoteDataSource.searchTvShows(query, page).map { it.toSearchResult() }
        }
    }

    // endregion
}