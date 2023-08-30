package com.redvelvet.repository.mapper

import com.redvelvet.entities.library.StatusEntity
import com.redvelvet.entities.library.WatchListMedia
import com.redvelvet.entities.library.list.CreateListResponse
import com.redvelvet.repository.dto.library.favorite.MovieFavoriteListDto
import com.redvelvet.repository.dto.library.favorite.TvFavoriteListDto
import com.redvelvet.repository.dto.library.list.CreateListResponseDto
import com.redvelvet.repository.dto.library.rated.user.UserRatedMoviesDto
import com.redvelvet.repository.dto.library.rated.user.UserRatedTvDto
import com.redvelvet.repository.dto.library.watchlist.WatchListMovieDto
import com.redvelvet.repository.dto.library.watchlist.WatchListTvDto
import com.redvelvet.repository.dto.tvShow.StatusResponseDto
import com.redvelvet.repository.utils.Constants

fun CreateListResponseDto.toDomain(): CreateListResponse {
    return CreateListResponse(
        statusCode = this.statusCode ?: 0,
        statusMessage = this.statusMessage ?: "",
        success = this.success ?: false,
        listId = this.listId ?: 0
    )
}

fun StatusResponseDto.toDomain(): StatusEntity {
    return StatusEntity(
        statusCode = this.statusCode ?: 0,
        statusMessage = this.statusMessage ?: " ",
        success = this.success
    )
}

fun MovieFavoriteListDto.toDomain(): WatchListMedia {
    return WatchListMedia(data = this.results.map {
        WatchListMedia.Data(
            id = it.id ?: 0,
            posterPath = "${Constants.ImageUrl}${it.posterPath}",
            name = it.originalTitle ?: "N/A",
            type = WatchListMedia.Data.Type.MOVIE
        )
    })
}

fun TvFavoriteListDto.toDomain(): WatchListMedia {
    return WatchListMedia(data = this.results.map {
        WatchListMedia.Data(
            id = it.id ?: 0,
            posterPath = "${Constants.ImageUrl}${it.posterPath}",
            name = it.originalName ?: "N/A",
            type = WatchListMedia.Data.Type.TV
        )
    })
}

fun WatchListMovieDto.toDomain(): WatchListMedia {
    return WatchListMedia(data = this.results.map {
        WatchListMedia.Data(
            id = it.id ?: 0,
            posterPath = "${Constants.ImageUrl}${it.posterPath}",
            name = it.originalTitle ?: "N/A",
            type = WatchListMedia.Data.Type.MOVIE
        )
    })
}

fun WatchListTvDto.toDomain(): WatchListMedia {
    return WatchListMedia(data = this.results.map {
        WatchListMedia.Data(
            id = it.id ?: 0,
            posterPath = "${Constants.ImageUrl}${it.posterPath}",
            name = it.originalName ?: "N/A",
            type = WatchListMedia.Data.Type.TV
        )
    })
}

fun UserRatedMoviesDto.toDomain(): WatchListMedia {
    return WatchListMedia(data = this.results.map {
        WatchListMedia.Data(
            id = it.id ?: 0,
            posterPath = "${Constants.ImageUrl}${it.posterPath}",
            name = it.title ?: "N/A",
            type = WatchListMedia.Data.Type.MOVIE
        )
    })
}


fun UserRatedTvDto.toDomain(): WatchListMedia {
    return WatchListMedia(data = this.results.map {
        WatchListMedia.Data(
            id = it.id ?: 0,
            posterPath = "${Constants.ImageUrl}${it.posterPath}",
            name = it.name ?: "N/A",
            type = WatchListMedia.Data.Type.TV
        )
    })
}


fun CreateListResponseDto.toCreateList(): CreateListResponse {
    return CreateListResponse(
        listId ?: 0, statusCode ?: 0, statusMessage ?: "", success ?: false
    )
}