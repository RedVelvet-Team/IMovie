package com.redvelvet.viewmodel.library

import com.redvelvet.viewmodel.base.BaseUiState

interface LibraryUiInteraction : BaseUiState {
    fun onClickPlayList(listId: Int)
    fun onClickAddPlayList(name: String)
    fun onClickFavItem(id: Int)
    fun onClearList(listId: Int)
    fun onDeleteList(listId: Int)
    fun onClickGotoLibrary()
    fun onClickLogin()

}