package com.redvelvet.usecase.usecase.libraryList

import com.redvelvet.entities.library.LibraryDetails
import com.redvelvet.usecase.repository.LibraryListsRepository
import com.redvelvet.usecase.repository.LibraryRepository
import com.redvelvet.usecase.usecase.auth.GetAccountIDUsecase
import com.redvelvet.usecase.usecase.auth.GetUserSessionIdUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetLibraryDataUseCase @Inject constructor(
    private val libraryListsRepository: LibraryListsRepository,
    private val libraryRepository: LibraryRepository,
    private val getAccountIDUsecase: GetAccountIDUsecase,
    private val getUserSessionIdUseCase: GetUserSessionIdUseCase
) {
    suspend operator fun invoke() = coroutineScope {
        try {
            val accIdDeferred = async { getAccountIDUsecase.invoke() }
            val sessionDeferred = async { getUserSessionIdUseCase.invoke() }
            val accId = accIdDeferred.await()
            val session = sessionDeferred.await()


            val watchListsDeferred = async { libraryListsRepository.getLists(accId.id, session) }
            val favoritesMovieDeferred =
                async { libraryRepository.getFavoriteMovies(accId.id, session) }
            val favoritesTvDeferred = async { libraryRepository.getFavoriteTv(accId.id, session) }

            val watchLists = watchListsDeferred.await()
            val favMovie = favoritesMovieDeferred.await()
            val favTv = favoritesTvDeferred.await()

            LibraryDetails(
                watchLists,
                favMovie,
                favTv
            )

        } catch (e: Exception) {
            throw e
        }
    }


}