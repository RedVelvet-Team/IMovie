package com.redvelvet.viewmodel.library

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class LibraryUiEffect : BaseUiEffect {
    data class NavigateToMovie(val id: Int) : LibraryUiEffect()
    data class NavigateToTvShow(val listId: Int) : LibraryUiEffect()
    data class NavigateToList(val listId: Int) : LibraryUiEffect()
    data object NavigateToLibrary : LibraryUiEffect()
    data object NavigateToLogin : LibraryUiEffect()


}
