package com.redvelvet.viewmodel.episode

interface EpisodeDetailsInteraction {
    fun onClickBack()
    fun onClickFavorite(episodeID: Int)
    fun onClickSave(episodeID: Int)
    fun onClickTopCastSeeAll(topCastId: Int)
    fun onCLickImagesSeeAll(imagesId: Int)
    fun onClickCast(castId: Int)
    fun onClickVideo(videoKey: String)
    fun onCLickRefresh()
    fun onLoginRequired()
}