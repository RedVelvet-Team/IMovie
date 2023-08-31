package com.redvelvet.viewmodel.library

import com.redvelvet.viewmodel.base.BaseUiState

interface LibraryUiInteraction : BaseUiState {
    fun onClickSeeAllWatchLists()
    fun onClickSeeAllFavorites()
    fun onClickSeeAllHistory()
    fun onClickPlayList()
    fun onMenuClick()
    fun onClickAddPlayList()
    fun onClickFavItem()

}