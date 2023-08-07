package com.redvelvet.usecase.usecase.search

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.people.People
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSearchResultUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String): Flow<PagingData<SearchResult>> {
        return movieRepository.multiSearch(query)
    }
}