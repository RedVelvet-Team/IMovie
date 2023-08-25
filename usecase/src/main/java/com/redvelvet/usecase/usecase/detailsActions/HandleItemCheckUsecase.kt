package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.entities.library.LibraryMovie
import com.redvelvet.entities.library.LibraryTv
import com.redvelvet.usecase.usecase.library.GetMovieFavoritesUsecase
import com.redvelvet.usecase.usecase.library.GetMovieWatchListUsecase
import com.redvelvet.usecase.usecase.library.GetRatedMovieUsecase
import com.redvelvet.usecase.usecase.library.GetRatedTvUsecase
import com.redvelvet.usecase.usecase.library.GetTvFavoritesUsecase
import com.redvelvet.usecase.usecase.library.GetTvWatchListUsecase
import javax.inject.Inject

class HandleItemCheckUsecase @Inject constructor(
    private val getMovieFavoritesUsecase: GetMovieFavoritesUsecase,
    private val getRatedMovieUsecase: GetRatedMovieUsecase,
    private val getTvFavoritesUsecase: GetTvFavoritesUsecase,
    private val getMovieWatchListUsecase: GetMovieWatchListUsecase,
    private val getTvWatchListUsecase: GetTvWatchListUsecase,
    private val getRatedTvUsecase: GetRatedTvUsecase,
) {
    suspend operator fun invoke(itemId: Int, dataType: TypeOfData): Boolean {
        return when (dataType) {
            TypeOfData.MOVIE_FAVORITES -> isItemInMovieList(
                getMovieFavoritesUsecase.invoke(),
                itemId
            )

            TypeOfData.TV_FAVORITES -> isItemInTvList(getTvFavoritesUsecase.invoke(), itemId)
            TypeOfData.MOVIE_WATCHLIST -> isItemInMovieList(
                getMovieWatchListUsecase.invoke(),
                itemId
            )

            TypeOfData.TV_WATCHLIST -> isItemInTvList(getTvWatchListUsecase.invoke(), itemId)
            TypeOfData.RATED_TV -> isItemInTvList(getRatedTvUsecase.invoke(), itemId)
            TypeOfData.RATED_MOVIE -> isItemInMovieList(
                getRatedMovieUsecase.invoke(),
                itemId
            )
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

}