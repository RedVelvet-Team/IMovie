package com.redvelvet.usecase.usecase.search

import com.redvelvet.entities.search.SearchResult
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetTvShowsSearchResultUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(query: String): List<SearchResult>{
        return movieRepository
            .multiSearch(query)
            .filter { it.mediaType == "tv" }
    }
}