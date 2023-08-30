package com.redvelvet.usecase.usecase.library

import com.redvelvet.entities.library.WatchListMedia
import com.redvelvet.usecase.repository.LibraryRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.auth.GetSavedAccountDetailsIdUsecase
import javax.inject.Inject

class GetMovieFavoritesUsecase @Inject constructor(
    private val libraryRepository: LibraryRepository,
    private val getAccountId: GetSavedAccountDetailsIdUsecase,
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(): WatchListMedia {
        return libraryRepository.getFavoriteMovies(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
    }
}