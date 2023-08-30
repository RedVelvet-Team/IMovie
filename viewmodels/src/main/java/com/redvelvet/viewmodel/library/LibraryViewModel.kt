package com.redvelvet.viewmodel.library

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LibraryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<LibraryUiState, LibraryUiEffect>(LibraryUiState()), LibraryUiInteraction {

    init {
        getData()
    }

    private fun getData() {
        TODO("Not yet implemented")
    }


    override fun onClickSeeAllWatchLists() {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllFavorites() {
        TODO("Not yet implemented")
    }

    override fun onClickSeeAllHistory() {
        TODO("Not yet implemented")
    }

    override fun onClickPlayList() {
        TODO("Not yet implemented")
    }

    override fun onMenuClick() {
        TODO("Not yet implemented")
    }

    override fun onClickAddPlayList() {
        TODO("Not yet implemented")
    }

    override fun onClickFavItem() {
        TODO("Not yet implemented")
    }
}