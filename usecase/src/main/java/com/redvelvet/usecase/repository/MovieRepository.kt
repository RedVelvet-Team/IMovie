package com.redvelvet.usecase.repository

import androidx.paging.PagingData
import com.redvelvet.entities.actor.Actor
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun multiSearch(query: String, page: Int? = 1): Flow<PagingData<SearchResult>>
    fun searchPeople(query: String, page: Int? = 1): Flow<PagingData<Actor>>
    fun searchMovie(query: String, page: Int? = 1): Flow<PagingData<Movie>>
    fun searchTvShows(query: String, page: Int? = 1): Flow<PagingData<TvShow>>

    //region see all
    suspend fun seeAllAiringTodayTv(page: Int?): Flow<PagingData<TvShow>>
    suspend fun seeAllOnTheAir(page: Int?): Flow<PagingData<TvShow>>
    suspend fun seeAllPopularTv(page: Int?): Flow<PagingData<TvShow>>

    //endregion
}