package com.redvelvet.usecase.repository

import androidx.paging.PagingData
import com.redvelvet.entities.search.SearchResult
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun multiSearch(query: String, page: Int? = 1): Flow<PagingData<SearchResult>>
    suspend fun searchPeople(query: String, page: Int? = null): List<SearchResult>
    suspend fun searchMovie(query: String, page: Int? = null): List<SearchResult>
    suspend fun searchTvShows(query: String, page: Int? = null): List<SearchResult>
}