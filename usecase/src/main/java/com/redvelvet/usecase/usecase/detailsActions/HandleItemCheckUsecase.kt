package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.entities.library.LibraryMovie
import com.redvelvet.entities.library.LibraryTv
import com.redvelvet.usecase.repository.LibraryRepository
import com.redvelvet.usecase.repository.UserRepository
import com.redvelvet.usecase.usecase.auth.GetSavedAccountDetailsIdUsecase
import javax.inject.Inject

class HandleItemCheckUsecase @Inject constructor(
    private val libraryRepository: LibraryRepository,
    private val getAccountId: GetSavedAccountDetailsIdUsecase,
    private val userRepository: UserRepository,

    ) {
    suspend operator fun invoke(itemId: Int, dataType: DetailsActionsTypes): Boolean {
        return when (dataType) {
            DetailsActionsTypes.MOVIE_FAVORITES -> isItemInMovieList(
                getMovieFavorites(),
                itemId
            )

            DetailsActionsTypes.TV_FAVORITES -> isItemInTvList(getTvFavorites(), itemId)
            DetailsActionsTypes.MOVIE_WATCHLIST -> isItemInMovieList(
                getMovieWatchList(),
                itemId
            )

            DetailsActionsTypes.TV_WATCHLIST -> isItemInTvList(getTvWatchList(), itemId)
            DetailsActionsTypes.RATED_TV -> isItemInTvList(getRatedTv(), itemId)
            DetailsActionsTypes.RATED_MOVIE -> isItemInMovieList(
                getRatedMovie(),
                itemId
            )

            else -> false
        }
    }

    private fun isItemInMovieList(
        useCase: List<LibraryMovie>,
        itemId: Int
    ): Boolean {
        return useCase.run { isNotEmpty() && any { it.id == itemId } }
    }

    private fun isItemInTvList(
        useCase: List<LibraryTv>,
        itemId: Int
    ): Boolean {
        return useCase.run { isNotEmpty() && any { it.id == itemId } }
    }


    private suspend fun getTvWatchList(): List<LibraryTv> {
        return libraryRepository.getWatchlistTv(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()

        )
    }

    private suspend fun getTvFavorites(): List<LibraryTv> {
        return libraryRepository.getFavoriteTv(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
    }

    private suspend fun getMovieFavorites(): List<LibraryMovie> {
        return libraryRepository.getFavoriteMovies(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()

        )
    }

    private suspend fun getMovieWatchList(): List<LibraryMovie> {
        return libraryRepository.getWatchlistMovie(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()

        )
    }

    private suspend fun getRatedMovie(): List<LibraryMovie> {
        return libraryRepository.getRatedMovies(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()

        )
    }

    private suspend fun getRatedTv(): List<LibraryTv> {
        return libraryRepository.getRatedTv(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()

        )
    }

}