package com.redvelvet.ui.screen.home

interface HomeUiEvent {
    fun onClickSeeAll()
    fun onClickMovieItem(id: Int)
    fun onClickSeriesItem(id: Int)
}