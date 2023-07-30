package com.redvelvet.ui.home

interface HomeUiEvent {
    fun onClickSeeAll()
    fun onClickMovieItem(id: Int)
    fun onClickSeriesItem(id: Int)
}