package com.redvelvet.repository.mapper

import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.people.People
import com.redvelvet.entities.search.SearchResult
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.repository.dto.movie.MovieDto
import com.redvelvet.repository.dto.person.PersonDto
import com.redvelvet.repository.dto.search.BaseSearchDto
import com.redvelvet.repository.dto.search.MultiSearchResultDto
import com.redvelvet.repository.dto.series.SeriesDto

fun MultiSearchResultDto.toEntity(): SearchResult {
    return SearchResult(
        id = this.id,
        mediaType = this.mediaType,
        name = this.name,
        language = this.originalLanguage,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        firstAirDate = this.firstAirDate,
        originalName = this.title,
        profilePath = this.profilePath
    )
}

fun PersonDto.toPeopleEntity() = People(
    id = id ?: 0,
    name = name.orEmpty(),
    profileImage = profilePath.orEmpty(),
    birthday = birthday.orEmpty(),
    country = placeOfBirth.orEmpty()
)

fun MovieDto.toMovieEntity() = Movie(
    id = id ?: 0,
    name = originalTitle.orEmpty(),
    image = posterPath.orEmpty(),
    country = originalLanguage.orEmpty(),
    releaseDate = releaseDate.orEmpty(),
)

fun SeriesDto.toTvShowEntity() = TvShow(
    id = id ?: 0,
    name = name.orEmpty(),
    image = posterPath.orEmpty(),
    country = originalLanguage.orEmpty(),
    releaseDate = firstAirDate.orEmpty(),
)

fun BaseSearchDto.toEntity(): List<SearchResult> {
    return this.multiSearchResultDtos?.mapNotNull { it?.toEntity() } ?: emptyList()
}