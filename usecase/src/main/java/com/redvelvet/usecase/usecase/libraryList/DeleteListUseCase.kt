package com.redvelvet.usecase.usecase.libraryList

import com.redvelvet.usecase.repository.LibraryListsRepository
import com.redvelvet.usecase.usecase.auth.GetUserSessionIdUseCase
import javax.inject.Inject

class DeleteListUseCase @Inject constructor(
    private val libraryRepository: LibraryListsRepository,
    private val getUserSessionIdUseCase: GetUserSessionIdUseCase
) {
    suspend operator fun invoke(listId: Int) {
        println(getUserSessionIdUseCase())
        libraryRepository.deleteList(listId, getUserSessionIdUseCase())
    }
}