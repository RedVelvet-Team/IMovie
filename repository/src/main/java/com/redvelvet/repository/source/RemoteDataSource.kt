package com.redvelvet.repository.source

import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.tvShow.TvShowDto

interface RemoteDataSource {
    //region auth
    suspend fun createGuestSession(): GuestSessionDto
    suspend fun createToken(): TokenDto
    suspend fun validateUserWithLogin(userName: String, password: String, requestToken: String): TokenDto
    suspend fun createUserSession(token: String): SessionDto
    suspend fun deleteUserSession(sessionId: String): SessionDto
    //endregion

    //region Search
    suspend fun multiSearch(query: String, page : Int?): List<MultiSearchResultDto>
    suspend fun searchPeople(query: String, page : Int?): List<PersonDto>
    suspend fun searchMovie(query: String, page : Int?): List<MovieDto>
    suspend fun searchTvShows(query: String, page : Int?): List<TvShowDto>
    //endregion

    //region see all
    suspend fun seeAllPopularMovie(page: Int?): List<MovieDto>
    suspend fun seeAllUpcomingMovie(page: Int?): List<MovieDto>
    suspend fun seeAllNowPlayingMovie(page: Int?): List<MovieDto>
    suspend fun seeAllTopRatedMovie(page: Int?): List<MovieDto>
    suspend fun seeAllSimilarMovie(page: Int?, id: Int): List<MovieDto>
    suspend fun seeAllRecommendedMovie(page: Int?, id: Int): List<MovieDto>

    //endregion
}