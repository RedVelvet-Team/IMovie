package com.redvelvet.repository.mapper

import com.redvelvet.entities.search.SearchResult
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

fun PersonDto.toSearchResult() = SearchResult(
    id = this.id,
    mediaType = "person",
    name = this.name,
    language = null,
    posterPath = null,
    releaseDate = null,
    firstAirDate = null,
    originalName = null,
    profilePath = this.profilePath
)

fun MovieDto.toSearchResult() = SearchResult(
    id = this.id,
    mediaType = "movie",
    name = this.title,
    language = this.originalLanguage,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    firstAirDate = null,
    originalName = this.originalTitle,
    profilePath = null
)

fun SeriesDto.toSearchResult() = SearchResult(
    id = this.id,
    mediaType = "tv",
    name = this.name,
    language = this.originalLanguage,
    posterPath = this.posterPath,
    releaseDate = null,
    firstAirDate = this.firstAirDate,
    originalName = this.originalName,
    profilePath = null
)

fun BaseSearchDto.toEntity(): List<SearchResult> {
    return this.multiSearchResultDtos?.mapNotNull { it?.toEntity() } ?: emptyList()
}