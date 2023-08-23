package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class ToggleMediaInWatchListUsecase @Inject constructor(
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(mediaType: String, mediaId: Int, isSavedInWatchList: Boolean) =
        repository.toggleMediaInWatchList(
            mediaType = mediaType,
            mediaId = mediaId,
            isSavedInWatchList = isSavedInWatchList,
            accountId = 19656136,
            userRepository.getUserSessionIdFromLocal()
        )
}