package com.redvelvet.viewmodel.episode

import com.redvelvet.viewmodel.base.BaseUiEffect

interface EpisodeDetailsInteraction {
    fun onClickBack()
    fun onClickFavorite(episodeID: String)
    fun onClickSave(episodeID: String)
    fun onClickTopCastSeeAll(topCastId: String)
    fun onCLickImagesSeeAll(imagesId: String)
    fun onClickImage(imageId: String)
    fun onClickCast(castId: String)
    fun onClickVideo(videoKey: String)
    fun onCLickRefresh()
}

sealed class EpisodeDetailsUiEffect() : BaseUiEffect {
    data class NavigateToCastDetailsScreen(val id: String) : EpisodeDetailsUiEffect()
    data class NavigateToSeeAllCastDetailsScreen(val id: String) : EpisodeDetailsUiEffect()
    data class NavigateToImageScreen(val id: String) : EpisodeDetailsUiEffect()
    data class NavigateToSeeAllImagesScreen(val id: String) : EpisodeDetailsUiEffect()
    data class NavigateToVideoScreen(val key: String) : EpisodeDetailsUiEffect()
    data object NavigateUp : EpisodeDetailsUiEffect()
}