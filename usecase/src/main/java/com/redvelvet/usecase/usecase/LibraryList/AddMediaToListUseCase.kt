package com.redvelvet.usecase.usecase.LibraryList

import com.redvelvet.usecase.repository.LibraryListsRepository
import com.redvelvet.usecase.repository.UserRepository
import javax.inject.Inject

class AddMediaToListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository,
    private val userRepository: UserRepository,

    ) {
    suspend operator fun invoke(mediaId: Int, listId: Int) {
        libraryRepository.addMediaToList(
            listId,
            mediaId,
        )
//        userRepository.getUserSessionIdFromLocal()
    }
}