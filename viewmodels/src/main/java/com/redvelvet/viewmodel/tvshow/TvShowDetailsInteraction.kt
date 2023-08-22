package com.redvelvet.viewmodel.tvshow

interface TvShowDetailsInteraction {
    fun onClickBack()
    fun onClickFavorite(seriesId: Int)
    fun onClickSave(seriesId: Int)
    fun onClickPlayTrailer(seriesUrl: String)
    fun onClickCategory(genre: String)
    fun onClickRateSeries(seriesId: Int, rate: Double)
    fun onClickTopCastSeeAll(id: String)
    fun onClickCast(castId: Int)
    fun onClickKeyword(seriesId: Int)
    fun onClickSeasonSeaAll(seriesId: String)
    fun onClickSeason(seriesId: String, seasonId: Int)
    fun onClickPosterSeaAll(seriesId: String)
    fun onClickPoster(seriesId: Int, seasonNumber: Int)
    fun onClickReviewsSeeAll(seriesId: String)
    fun onClickReview(reviewId: String)
    fun onClickRecommendationsSeriesSeeAll(seriesId: String)
    fun onClickSeries(seriesId: String)
}