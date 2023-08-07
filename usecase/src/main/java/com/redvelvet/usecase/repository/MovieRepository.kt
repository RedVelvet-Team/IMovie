package com.redvelvet.usecase.repository

import androidx.paging.PagingData
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.people.People
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun multiSearch(query: String, page: Int? = 1): Flow<PagingData<SearchResult>>
    fun searchPeople(query: String, page: Int? = null): Flow<PagingData<People>>
    fun searchMovie(query: String, page: Int? = null): Flow<PagingData<Movie>>
    fun searchTvShows(query: String, page: Int? = null): Flow<PagingData<TvShow>>
}