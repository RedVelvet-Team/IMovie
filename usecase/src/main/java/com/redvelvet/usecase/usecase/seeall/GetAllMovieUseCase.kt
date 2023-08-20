package com.redvelvet.usecase.usecase.seeall

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend fun getPopular(): Flow<PagingData<Movie>>{
        return repository.seeAllPopularMovie(page = null)
    }

    suspend fun getTopRated(): Flow<PagingData<Movie>>{
        return repository.seeAllTopRatedMovie(page = null)
    }

    suspend fun getUpcoming(): Flow<PagingData<Movie>>{
        return repository.seeAllUpcomingMovie(page = null)
    }

    suspend fun getNowPlaying(): Flow<PagingData<Movie>>{
        return repository.seeAllNowPlayingMovie(page = null)
    }

    suspend fun getSimilar(id: Int): Flow<PagingData<Movie>>{
        return repository.seeAllSimilarMovie(id)
    }

    suspend fun getRecommended(id: Int): Flow<PagingData<Movie>>{
        return repository.seeAllRecommendedMovie(id)
    }
}