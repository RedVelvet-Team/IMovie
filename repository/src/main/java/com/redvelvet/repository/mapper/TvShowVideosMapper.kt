package com.redvelvet.repository.mapper

import com.redvelvet.entities.tv.TvShowResultVideo
import com.redvelvet.entities.tv.TvShowVideos
import com.redvelvet.repository.dto.tvShow.TvShowResultVideoDto
import com.redvelvet.repository.dto.tvShow.TvShowVideosDto
import com.redvelvet.repository.localDto.TvShowResultVideoLocalDto
import com.redvelvet.repository.localDto.TvShowVideosLocalDto

fun TvShowVideosDto.toTvShowVideosLocalDto() = TvShowVideosLocalDto(
    videos = results?.map { it?.toTvShowResultVideosLocalDto() ?: TvShowResultVideoLocalDto() }
        ?: emptyList()
)

fun TvShowResultVideoDto.toTvShowResultVideosLocalDto() = TvShowResultVideoLocalDto(
    site = site ?: "",
    key = key ?: ""
)

fun TvShowVideosDto.toTvShowVideos() = TvShowVideos(
    videos = results?.map { it?.toTvShowResultVideos() ?: TvShowResultVideo() } ?: emptyList()
)

fun TvShowResultVideoDto.toTvShowResultVideos() = TvShowResultVideo(
    site = site ?: "",
    key = key ?: ""
)