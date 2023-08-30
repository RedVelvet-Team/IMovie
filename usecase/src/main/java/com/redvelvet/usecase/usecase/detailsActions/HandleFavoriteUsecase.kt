package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.auth.GetSavedAccountDetailsIdUsecase
import javax.inject.Inject

class HandleFavoriteUsecase @Inject constructor(
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
            "movie" -> DetailsActionsTypes.MOVIE_FAVORITES
            "tv" -> DetailsActionsTypes.TV_FAVORITES
            else -> DetailsActionsTypes.UNKNOWN
        }
        return if (handleItemCheckUsecase.invoke(mediaId, dataType)) {
            toggleMediaInFavorites(mediaType, mediaId, false)
        } else {
            toggleMediaInFavorites(mediaType, mediaId, true)
        }
    }

    private suspend fun toggleMediaInFavorites(
        mediaType: String,
        mediaId: Int,
        isSavedInFavorites: Boolean
    ): String =
        repository.toggleMediaInFavorites(
            mediaType = mediaType,
            mediaId = mediaId,
            isSavedInFavorites = isSavedInFavorites,
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
}