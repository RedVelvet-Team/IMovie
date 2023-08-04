package com.redvelvet.repository.repository

import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.mapper.toEntity
import com.redvelvet.repository.mapper.toSearchResult
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource
) : MovieRepository, BaseRepository() {

    //region search
    override suspend fun multiSearch(
        query: String,
        page: Int?
    ): List<SearchResult> {
        return wrapRemoteResponse {
            remoteDataSource.multiSearch(query, page).map { it.toEntity() }
        }
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