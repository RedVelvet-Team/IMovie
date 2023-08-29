package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowKeywords
import com.redvelvet.entities.tv.TvShowKeywordsResult
import com.redvelvet.repository.dto.schema.ItemKeyword
import com.redvelvet.repository.dto.tvShow.TvShowKeywordsDto
import com.redvelvet.repository.localDto.TvShowKeywordsLocalDto
import com.redvelvet.repository.localDto.TvShowKeywordsResultLocalDto


fun TvShowKeywordsDto.toTvShowKeywordsLocalDto() = TvShowKeywordsLocalDto(
    id = id ?: 0,
    tvShowKeywords = results?.map {
        it?.toTvShowKeywordsResultLocalDto() ?: TvShowKeywordsResultLocalDto()
    } ?: emptyList()
)

fun ItemKeyword.toTvShowKeywordsResultLocalDto() = TvShowKeywordsResultLocalDto(
    id = id ?: 0,
    name = name ?: ""
)

fun TvShowKeywordsDto.toTvShowKeywords() = TvShowKeywords(
    id = id,
    tvShowKeywords = results?.map { it?.toTvShowKeywordsResult() ?: TvShowKeywordsResult() }
        ?: emptyList()
)

fun ItemKeyword.toTvShowKeywordsResult() = TvShowKeywordsResult(
    id = id ?: 0,
    name = name ?: ""
)