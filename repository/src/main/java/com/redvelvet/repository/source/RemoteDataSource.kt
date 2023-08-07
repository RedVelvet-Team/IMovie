package com.redvelvet.repository.source

import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.BaseSearchDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.series.SeriesDto

interface RemoteDataSource {
    suspend fun multiSearch(query: String, page : Int?): List<MultiSearchResultDto>
    suspend fun searchPeople(query: String, page : Int?): List<PersonDto>
    suspend fun searchMovie(query: String, page : Int?): List<MovieDto>
    suspend fun searchTvShows(query: String, page : Int?): List<SeriesDto>
}