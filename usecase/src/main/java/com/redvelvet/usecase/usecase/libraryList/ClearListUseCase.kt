package com.redvelvet.usecase.usecase.libraryList

import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class ClearListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository
) {
    suspend operator fun invoke(listId: Int) {
        libraryRepository.clearList(listId)
    }
}