package com.redvelvet.viewmodel.search

interface SearchListener {
    fun onClickClear()
    fun onClickAllChip()
    fun onClickMovieChip()
    fun onClickTvShowChip()
    fun onClickActorChip()
    fun onClickItem(id: Int)
    fun onCLickRefresh()
}