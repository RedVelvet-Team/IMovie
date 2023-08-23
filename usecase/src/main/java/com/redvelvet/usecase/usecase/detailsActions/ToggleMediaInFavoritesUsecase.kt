package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class ToggleMediaInFavoritesUsecase @Inject constructor(
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(
        mediaType: String,
        mediaId: Int,
        isSavedInFavorites: Boolean
    ): String =
        repository.toggleMediaInFavorites(
            mediaType = mediaType,
            mediaId = mediaId,
            isSavedInFavorites = isSavedInFavorites,
            accountId = 19656136,
            userRepository.getUserSessionIdFromLocal()
        )
}