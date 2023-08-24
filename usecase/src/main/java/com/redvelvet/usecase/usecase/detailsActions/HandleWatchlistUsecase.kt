package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.usecase.library.GetMovieWatchListUsecase
import javax.inject.Inject

class HandleWatchlistUsecase @Inject constructor(
    private val getMovieWatchListUsecase: GetMovieWatchListUsecase,
    private val toggleMediaInWatchListUsecase: ToggleMediaInWatchListUsecase,
) {
    suspend operator fun invoke(
        mediaType: String,
        mediaId: Int,
    ): String {
        val isListHasItem = getMovieWatchListUsecase.invoke().any { it.id == mediaId }
        return if (isListHasItem) {
            toggleMediaInWatchListUsecase.invoke(mediaType, mediaId, false)
        } else {
            toggleMediaInWatchListUsecase.invoke(mediaType, mediaId, true)
        }
    }
}