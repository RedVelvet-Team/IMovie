package com.redvelvet.viewmodel.library

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class LibraryUiEffect : BaseUiEffect {
    data object NavigateToSeeAllWatchLists : LibraryUiEffect()
    data object NavigateToSeeAllFavorites : LibraryUiEffect()
    data object NavigateToSeeAllHistory : LibraryUiEffect()
    data object NavigateToMovie : LibraryUiEffect()
    data object NavigateToTvShow : LibraryUiEffect()

}
