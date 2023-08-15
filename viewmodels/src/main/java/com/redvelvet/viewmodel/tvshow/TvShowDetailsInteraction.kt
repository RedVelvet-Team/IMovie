package com.redvelvet.viewmodel.tvshow

interface TvShowDetailsInteraction {
    fun onClickBack()
    fun onClickFavorite(seriesId: Int)
    fun onClickSave(seriesId: Int)
    fun onClickPlayTrailer(seriesUrl: String)
    fun onClickCategory(seriesId: Int)
    fun onClickRateSeries(seriesId: Int, rate: Double)
    fun onClickTopCastSeeAll()
    fun onClickCast(castId: Int)
    fun onClickKeyword(seriesId: Int)
    fun onClickSeasonSeaAll()
    fun onClickSeason(seriesId: Int,seasonId: Int)
    fun onClickPosterSeaAll()
    fun onClickPoster(seriesId: Int,seasonNumber: Int)
    fun onClickReviewsSeeAll()
    fun onClickReview(reviewId: Int)
    fun onClickRecommendationsSeriesSeeAll()
    fun onClickRecommendation(seriesId: Int,recommendationId: Int)
}