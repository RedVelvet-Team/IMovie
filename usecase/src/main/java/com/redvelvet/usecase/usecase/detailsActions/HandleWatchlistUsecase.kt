package com.redvelvet.usecase.usecase.detailsActions

import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class HandleWatchlistUsecase @Inject constructor(
    private val handleItemCheckUsecase: HandleItemCheckUsecase,
    private val toggleMediaInWatchListUsecase: ToggleMediaInWatchListUsecase,
) {
    suspend operator fun invoke(
        mediaType: String,
        mediaId: Int,
    ): String {
        return coroutineScope {
            val dataType = when (mediaType) {
                "movie" -> TypeOfData.MOVIE_WATCHLIST
                "tv" -> TypeOfData.TV_WATCHLIST
                else -> throw IllegalArgumentException("Invalid mediaType")
            }
            if (handleItemCheckUsecase.invoke(mediaId, dataType)) {
                toggleMediaInWatchListUsecase.invoke(mediaType, mediaId, false)
            } else {
                toggleMediaInWatchListUsecase.invoke(mediaType, mediaId, true)
            }
        }
    }
}