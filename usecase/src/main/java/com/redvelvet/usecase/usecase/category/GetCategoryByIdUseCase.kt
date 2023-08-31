package com.redvelvet.usecase.usecase.category

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCategoryByIdUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun getCategoryMovieById(id: Int): Flow<PagingData<Movie>> {
        return repository.getMovieCategoryById(id)
    }

    suspend fun getCategoryTvById(id: Int): Flow<PagingData<TvShow>> {
        return repository.getTvCategoryById(id)
    }
}