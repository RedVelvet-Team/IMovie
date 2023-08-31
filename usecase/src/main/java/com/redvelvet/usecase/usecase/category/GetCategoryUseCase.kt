package com.redvelvet.usecase.usecase.category

import com.redvelvet.entities.Genre
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun getCategoryMovie(): List<Genre> {
        return repository.getMovieCategory()
    }

    suspend fun getCategoryTv(): List<Genre> {
        return repository.getTvCategory()
    }
}