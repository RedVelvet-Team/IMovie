package com.redvelvet.usecase.usecase.search

import androidx.paging.PagingData
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchTvShowUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String): Flow<PagingData<TvShow>> {
        return movieRepository.searchTvShows(query = query, page = null)
    }
}