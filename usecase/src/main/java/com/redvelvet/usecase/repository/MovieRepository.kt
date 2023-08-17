package com.redvelvet.usecase.repository

import com.redvelvet.entities.movie.details.*

import androidx.paging.PagingData
import com.redvelvet.entities.actor.Actor
import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.SeasonTvShow
import com.redvelvet.entities.tv.TvShow
import kotlinx.coroutines.flow.Flow


interface MovieRepository {
    fun multiSearch(query: String, page: Int?=1): Flow<PagingData<SearchResult>>
    fun searchPeople(query: String, page: Int?=1): Flow<PagingData<Actor>>
    fun searchMovie(query: String, page: Int?=1): Flow<PagingData<Movie>>
    fun searchTvShows(query: String, page: Int?=1): Flow<PagingData<TvShow>>


    //region Movie Details
    suspend fun getMovieDetailsById(movieId: Int): MovieDetails
    suspend fun getMovieImagesByID(movieId: Int): MovieImages
    suspend fun getMovieKeyWordsByID(movieId: Int):MovieKeyWords
    suspend fun getMovieRecommendationsByID(movieId: Int):MovieRecommendations
    suspend fun getMovieReviewsByID(movieId: Int):MovieReviews
    suspend fun getMovieSimilarByID(movieId: Int):MovieSimilar
    suspend fun getMovieTopCastByID(movieId: Int):MovieTopCast
    suspend fun getAllSeasons(seriesId: Int): List<SeasonTvShow>

    //endregion
}