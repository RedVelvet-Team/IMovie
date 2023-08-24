package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.usecase.library.GetMovieFavoritesUsecase
import javax.inject.Inject

class HandleFavoriteUsecase @Inject constructor(
    private val getMovieFavoritesUsecase: GetMovieFavoritesUsecase,
    private val toggleMediaInFavoritesUsecase: ToggleMediaInFavoritesUsecase,
) {
    suspend operator fun invoke(
        mediaType: String,
        mediaId: Int,
    ): String {
        val isListHasItem = getMovieFavoritesUsecase.invoke().any { it.id == mediaId }
        return if (isListHasItem) {
            toggleMediaInFavoritesUsecase.invoke(mediaType, mediaId, false)
        } else {
            toggleMediaInFavoritesUsecase.invoke(mediaType, mediaId, true)
        }
    }
}