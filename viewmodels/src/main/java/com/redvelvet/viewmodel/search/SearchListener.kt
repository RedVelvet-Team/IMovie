package com.redvelvet.viewmodel.search

interface SearchListener {
    fun onClickClear()
    fun showResultAll()
    fun showResultMovie()
    fun showResultTv()
    fun showResultPeople()
    fun onClickItem(id: Int)

}