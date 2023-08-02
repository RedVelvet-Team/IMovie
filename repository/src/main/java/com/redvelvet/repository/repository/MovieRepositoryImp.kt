package com.redvelvet.repository.repository

import com.redvelvet.repository.source.FirebaseDataSource
import com.redvelvet.repository.source.LocalDataSource
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.MovieRepository
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.repository.mapper.toEntity
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val firebaseDataSource: FirebaseDataSource
) : MovieRepository, BaseRepository() {
    override suspend fun multiSearch(
        query: String,
        page: Int?
    ): List<SearchResult> {
        return remoteDataSource.multiSearch(query, page).toEntity()
    }
}