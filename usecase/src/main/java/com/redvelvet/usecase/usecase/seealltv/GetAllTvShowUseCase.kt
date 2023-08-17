package com.redvelvet.usecase.usecase.seealltv

import androidx.paging.PagingData
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTvSeriesUseCase @Inject constructor(
    private val repo: MovieRepository
) {

    suspend fun getAiringTodayTv(): Flow<PagingData<TvShow>> {
        return repo.seeAllAiringTodayTv(page = null)
    }

    suspend fun getOnTheAir(): Flow<PagingData<TvShow>> {
        return repo.seeAllOnTheAir(page = null)
    }

    suspend fun getPopularTv(): Flow<PagingData<TvShow>> {
        return repo.seeAllPopularTv(page = null)
    }

    suspend fun getTopRatedTv(): Flow<PagingData<TvShow>> {
        return repo.seeAllTopRatedTv(page = null)
    }

}