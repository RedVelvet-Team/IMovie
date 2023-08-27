package com.redvelvet.usecase.usecase.LibraryList

import com.redvelvet.entities.library.CreateList
import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class CreateListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository,
) {

    suspend fun getTopRated(
        sessionId: String,
        name: String,
        description: String?,
        language: String?
    ): CreateList {
        return libraryRepository.createList(sessionId, name, description, language)
    }

}