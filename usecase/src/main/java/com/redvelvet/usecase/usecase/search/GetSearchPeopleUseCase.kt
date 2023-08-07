package com.redvelvet.usecase.usecase.search

import androidx.paging.PagingData
import com.redvelvet.entities.people.People
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchPeopleUseCase @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(query: String): Flow<PagingData<People>> {
        return movieRepository.searchPeople(query)
    }
}