package com.redvelvet.usecase.usecase.search

import androidx.paging.PagingData
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(query: String): Flow<PagingData<SearchResult>> {
        return movieRepository.multiSearch(query)
    }

    suspend fun searchMovie(query: String): List<SearchResult> {
        return movieRepository.searchMovie(query)
    }

    suspend fun searchPeople(query: String): List<SearchResult> {
        return movieRepository.searchPeople(query)
    }

    suspend fun searchTvShows(query: String): List<SearchResult> {
        return movieRepository.searchTvShows(query)
    }
}