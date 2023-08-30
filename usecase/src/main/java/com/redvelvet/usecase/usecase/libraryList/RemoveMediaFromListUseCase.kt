package com.redvelvet.usecase.usecase.libraryList

import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class RemoveMediaFromListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository
) {
    suspend operator fun invoke(mediaId: Int, listId: Int, sessionId: String) {
        libraryRepository.removeMediaFromList(
            listId = listId,
            mediaId = mediaId,
            sessionId = sessionId
        )
    }
}