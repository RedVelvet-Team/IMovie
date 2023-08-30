package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.Poster
import com.redvelvet.entities.tv.TvShowImages
import com.redvelvet.repository.dto.schema.ImagesDto
import com.redvelvet.repository.dto.schema.ItemPoster
import com.redvelvet.repository.localDto.PosterLocalDto
import com.redvelvet.repository.localDto.TvShowImagesLocalDto

fun ImagesDto.toTvShowImagesLocalDto() = TvShowImagesLocalDto(
    posters = posters.map { it.toPosterLocalDto() ?: PosterLocalDto() } ?: emptyList()

)

fun ItemPoster.toPosterLocalDto() = PosterLocalDto(
    filePath = filePath ?: ""
)

fun ImagesDto.toTvShowImages() = TvShowImages(
    posters = posters.map { it.toPoster() ?: Poster() } ?: emptyList()

)

fun ItemPoster.toPoster() = Poster(
    filePath = filePath ?: ""
)