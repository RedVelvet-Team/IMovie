package com.redvelvet.usecase.usecase.libraryList

import com.redvelvet.entities.library.list.CreateListResponse
import com.redvelvet.usecase.repository.LibraryListsRepository
import com.redvelvet.usecase.usecase.auth.GetUserSessionIdUseCase
import javax.inject.Inject

class CreateListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository,
    private val getUserSessionIdUseCase: GetUserSessionIdUseCase
) {

    suspend fun invoke(
        name: String,
    ): CreateListResponse {
        val session = getUserSessionIdUseCase.invoke()
        return libraryRepository.createList(name = name, sessionId = session)
    }

}