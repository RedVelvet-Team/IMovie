package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.usecase.repository.MediaActionsRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.auth.GetSavedAccountDetailsIdUsecase
import com.redvelvet.usecase.usecase.user.CheckUserLoggedInUseCase
import javax.inject.Inject

class ToggleMediaInWatchListUsecase @Inject constructor(
    private val repository: MediaActionsRepository,
    private val userRepository: UserRepository,
    private val getAccountId: GetSavedAccountDetailsIdUsecase,
) {

    suspend operator fun invoke(
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