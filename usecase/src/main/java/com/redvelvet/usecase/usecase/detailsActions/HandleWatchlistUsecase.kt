package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.auth.GetSavedAccountDetailsIdUsecase
import javax.inject.Inject

class HandleWatchlistUsecase @Inject constructor(
    private val handleItemCheckUsecase: HandleItemCheckUsecase,
    private val repository: MediaActionsRepository,
    private val getAccountId: GetSavedAccountDetailsIdUsecase,
    private val userRepository: UserRepository,

    ) {
    suspend operator fun invoke(
        mediaType: String,
        mediaId: Int,
    ): String {
        val dataType = when (mediaType) {
            "movie" -> DetailsActionsTypes.MOVIE_WATCHLIST
            "tv" -> DetailsActionsTypes.TV_WATCHLIST
            else -> DetailsActionsTypes.UNKNOWN
        }
        return if (handleItemCheckUsecase.invoke(mediaId, dataType)) {
            toggleMediaInWatchList(mediaType, mediaId, false)
        } else {
            toggleMediaInWatchList(mediaType, mediaId, true)
        }

    }

    private suspend fun toggleMediaInWatchList(
        mediaType: String,
        mediaId: Int,
        isSavedInWatchList: Boolean
    ): String =
        repository.toggleMediaInWatchList(
            mediaType = mediaType,
            mediaId = mediaId,
            isSavedInWatchList = isSavedInWatchList,
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )

}