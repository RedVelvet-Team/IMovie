package com.redvelvet.viewmodel.tvshow

interface TvShowDetailsInteraction {
    fun onClickBack()
    fun onClickFavorite(seriesId: Int)
    fun onClickSave(seriesId: Int)
    fun onClickPlayTrailer(seriesUrl: String)
    fun onClickRateSeries(seriesId: Int, rate: Double)
    fun onClickTopCastSeeAll()
    fun onClickCast(castId: Int)
    fun onClickSeasonSeaAll()
    fun onClickPosterSeaAll()
    fun onClickReviewsSeeAll()
    fun onClickReview(reviewId: Int)
    fun onClickRecommendationsSeriesSeeAll()
}