package com.redvelvet.usecase.usecase.LibraryList

import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class ClearListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository
) {
    suspend operator fun invoke(listId: Int) {
        libraryRepository.clearList(listId)
    }
}