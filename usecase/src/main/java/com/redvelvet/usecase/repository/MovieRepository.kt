package com.redvelvet.usecase.repository

import com.redvelvet.entities.search.SearchResult

interface MovieRepository {
    suspend fun multiSearch(query: String, page: Int? = null): List<SearchResult>
}