package com.redvelvet.repository.source

import com.redvelvet.repository.dto.ActorKnownForDto
import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.ActorDto
import com.redvelvet.repository.dto.search.CombinedResultDto
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
    suspend fun multiSearch(query: String, page : Int?): List<CombinedResultDto>
    suspend fun searchPeople(query: String, page : Int?): List<ActorDto>
    suspend fun searchMovie(query: String, page : Int?): List<MovieDto>
    suspend fun searchTvShows(query: String, page : Int?): List<TvShowDto>
    //endregion

    suspend fun getActorDetails(id: Int): ActorDto

    suspend fun getActorKnownFor(id: Int) : ActorKnownForDto
}