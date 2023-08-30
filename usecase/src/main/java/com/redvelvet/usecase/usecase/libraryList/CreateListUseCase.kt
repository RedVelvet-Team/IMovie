package com.redvelvet.usecase.usecase.libraryList

import com.redvelvet.entities.library.list.CreateListResponse
import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class CreateListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository,
) {

    suspend fun invoke(
        name: String,
    ): CreateListResponse {
        return libraryRepository.createList(name)
    }

}