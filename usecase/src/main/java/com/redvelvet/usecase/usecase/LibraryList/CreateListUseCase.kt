package com.redvelvet.usecase.usecase.LibraryList

import com.redvelvet.entities.library.CreateList
import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class CreateListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository,
) {

    suspend fun invoke(
        name: String,
    ): CreateList {
        return libraryRepository.createList(name)
    }

}