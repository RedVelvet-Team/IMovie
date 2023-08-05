package com.redvelvet.repository.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.mapper.toEntity
import com.redvelvet.repository.mapper.toSearchResult
import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource,
) : MovieRepository, BaseRepository() {

    //region search
    override suspend fun multiSearch(
        query: String,
        page: Int?
    ): Flow<PagingData<List<SearchResult>>> {
        return Pager(
            config = PagingConfig(pageSize = 200, prefetchDistance = 2),
            pagingSourceFactory = {
                MultiSearchResultsPageDataSource(
                    query = query,
                    remoteDataSource = remoteDataSource
                )
            }
        ).flow.map { pagingData ->
            pagingData.map { searchResultDto ->
                searchResultDto.map {
                    it.toEntity()
                }
            }
        }
    }
//        return wrapRemoteResponse {
//            remoteDataSource.multiSearch(query, page).map { it.toEntity() }
//        }


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