package com.redvelvet.usecase.usecase.libraryList

import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class DeleteListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository
) {
    suspend operator fun invoke(listId: Int, sessionId: String) {
        libraryRepository.deleteList(listId, sessionId)
    }
}