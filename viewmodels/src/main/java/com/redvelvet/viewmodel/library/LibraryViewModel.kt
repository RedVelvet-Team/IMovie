package com.redvelvet.viewmodel.library

import com.redvelvet.usecase.usecase.library.GetMovieFavoritesUsecase
import com.redvelvet.usecase.usecase.library.GetMovieWatchListUsecase
import com.redvelvet.usecase.usecase.library.GetTvWatchListUsecase
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LibraryViewModel @Inject constructor(
    getMovieFavoritesUsecase: GetMovieFavoritesUsecase,
    getTvFavoritesUsecase: GetMovieFavoritesUsecase,
    getMovieWatchListUsecase: GetMovieWatchListUsecase,
    getTvWatchListUsecase: GetTvWatchListUsecase
) : BaseViewModel<LibraryUiState, LibraryUiEffect>(LibraryUiState()), LibraryUiInteraction {

    init {
        getData()
    }

    private fun getData() {

    }


    override fun onClickSeeAllWatchLists() {
        /*TODO("Not yet implemented")*/
    }

    override fun onClickSeeAllFavorites() {
        /*TODO("Not yet implemented")*/
    }

    override fun onClickSeeAllHistory() {
        /*TODO("Not yet implemented")*/
    }

    override fun onClickPlayList() {
        /*TODO("Not yet implemented")*/
    }

    override fun onMenuClick() {
        /*TODO("Not yet implemented")*/
    }

    override fun onClickAddPlayList() {
        /*TODO("Not yet implemented")*/
    }

    override fun onClickFavItem() {
        /*TODO("Not yet implemented")*/
    }

}