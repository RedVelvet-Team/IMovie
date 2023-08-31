package com.redvelvet.usecase.usecase.detailsActions


import com.redvelvet.entities.library.WatchListMedia
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

    fun isItemInMovieList(
        movieList: WatchListMedia,
        itemId: Int
    ): Boolean {
        return movieList.data.run { isNotEmpty() && any { it.id == itemId } }
    }

    fun isItemInTvList(
        tvList: WatchListMedia,
        itemId: Int
    ): Boolean {
        return tvList.data.run { isNotEmpty() && any { it.id == itemId } }
    }


    suspend fun getTvWatchList(): WatchListMedia {
        return libraryRepository.getWatchlistTv(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()

        )
    }

    suspend fun getTvFavorites(): WatchListMedia {
        return libraryRepository.getFavoriteTv(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
    }

    suspend fun getMovieFavorites(): WatchListMedia {
        return libraryRepository.getFavoriteMovies(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()

        )
    }

    suspend fun getMovieWatchList(): WatchListMedia {
        return libraryRepository.getWatchlistMovie(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
    }

    suspend fun getRatedMovie(): WatchListMedia {
        return libraryRepository.getRatedMovies(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
    }

    suspend fun getRatedTv(): WatchListMedia {
        return libraryRepository.getRatedTv(
            accountId = getAccountId.invoke(),
            userRepository.getUserSessionIdFromLocal()
        )
    }

}