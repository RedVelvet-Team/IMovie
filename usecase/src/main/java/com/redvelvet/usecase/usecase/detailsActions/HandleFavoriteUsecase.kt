package com.redvelvet.usecase.usecase.detailsActions

import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class HandleFavoriteUsecase @Inject constructor(
    private val toggleMediaInFavoritesUsecase: ToggleMediaInFavoritesUsecase,
    private val handleItemCheckUsecase: HandleItemCheckUsecase,
) {
    suspend operator fun invoke(
        mediaType: String,
        mediaId: Int,
    ): String {
        return coroutineScope {
            val dataType = when (mediaType) {
                "movie" -> TypeOfData.MOVIE_FAVORITES
                "tv" -> TypeOfData.TV_FAVORITES
                else -> throw IllegalArgumentException("Invalid mediaType")
            }
            if (handleItemCheckUsecase.invoke(mediaId, dataType)) {
                toggleMediaInFavoritesUsecase.invoke(mediaType, mediaId, false)
            } else {
                toggleMediaInFavoritesUsecase.invoke(mediaType, mediaId, true)
            }
        }
    }
}