package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.Poster
import com.redvelvet.entities.tv.TvShowImages
import com.redvelvet.repository.dto.tvShow.PosterDto
import com.redvelvet.repository.dto.tvShow.TvShowImagesDto
import com.redvelvet.repository.localDto.PosterLocalDto
import com.redvelvet.repository.localDto.TvShowImagesLocalDto

fun TvShowImagesDto.toTvShowImagesLocalDto() = TvShowImagesLocalDto(
    posters = posters?.map { it?.toPosterLocalDto() ?: PosterLocalDto() } ?: emptyList()

)

fun PosterDto.toPosterLocalDto() = PosterLocalDto(
    filePath = filePath ?: ""
)

fun TvShowImagesDto.toTvShowImages() = TvShowImages(
    posters = posters?.map { it?.toPoster() ?: Poster() } ?: emptyList()

)

fun PosterDto.toPoster() = Poster(
    filePath = filePath ?: ""
)