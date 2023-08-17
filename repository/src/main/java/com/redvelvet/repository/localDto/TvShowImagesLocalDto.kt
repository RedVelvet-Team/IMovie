package com.redvelvet.repository.localDto

data class TvShowImagesLocalDto(
    val posters: List<PosterLocalDto> = emptyList()
)

data class PosterLocalDto(
    val filePath: String = ""
)