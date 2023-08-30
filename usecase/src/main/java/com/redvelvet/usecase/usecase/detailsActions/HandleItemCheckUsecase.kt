package com.redvelvet.usecase.usecase.detailsActions

import com.redvelvet.entities.library.WatchListMedia
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
                getMovieFavoritesUsecase.invoke().data,
                itemId
            )

            TypeOfData.TV_FAVORITES -> isItemInTvList(getTvFavoritesUsecase.invoke().data, itemId)
            TypeOfData.MOVIE_WATCHLIST -> isItemInMovieList(
                getMovieWatchListUsecase.invoke().data,
                itemId
            )

            TypeOfData.TV_WATCHLIST -> isItemInTvList(getTvWatchListUsecase.invoke().data, itemId)
            TypeOfData.RATED_TV -> isItemInTvList(getRatedTvUsecase.invoke().data, itemId)
            TypeOfData.RATED_MOVIE -> isItemInMovieList(getRatedMovieUsecase.invoke().data, itemId)
        }
    }

    private fun isItemInMovieList(
        useCase: List<WatchListMedia.Data>,
        itemId: Int
    ): Boolean {
        return useCase.run { isNotEmpty() && any { it.id == itemId } }
    }

    private fun isItemInTvList(
        useCase: List<WatchListMedia.Data>,
        itemId: Int
    ): Boolean {
        return useCase.run { isNotEmpty() && any { it.id == itemId } }
    }

}