package com.redvelvet.usecase.repository

import com.redvelvet.entities.search.SearchResult

interface MovieRepository {
    suspend fun multiSearch(query: String, page: Int? = null): List<SearchResult>
    suspend fun searchPeople(query: String, page: Int? = null): List<SearchResult>
    suspend fun searchMovie(query: String, page: Int? = null): List<SearchResult>
    suspend fun searchTvShows(query: String, page: Int? = null): List<SearchResult>
}