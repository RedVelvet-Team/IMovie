package com.redvelvet.viewmodel.tvshow


import android.util.Log
import com.redvelvet.entities.tv.TvShowAllDetails
import com.redvelvet.usecase.usecase.tvshow.GetAllTvShowDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val getTvShSowDetails: GetAllTvShowDetailsUseCase,
) : BaseViewModel<SeriesDetailsUiState, TvShowUiEffect>(SeriesDetailsUiState()),
    TvShowDetailsInteraction {

    private val seriesId: Int = 1396

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            execute = { getTvShSowDetails(seriesId) },
            onSuccessWithData = ::onSuccess,
            onError = ::onError,
        )
    }

    private fun onSuccess(tvShowAllDetails: TvShowAllDetails) {
        _state.update {
            it.copy(
                tvShowName = tvShowAllDetails.tvShowName,
                tvShowImage = tvShowAllDetails.tvShowImage,
                tvShowLanguage = tvShowAllDetails.tvShowLanguage,
                tvShowTrailerUrl = tvShowAllDetails.tvShowTrailerUrl,
                tvShowDescription = tvShowAllDetails.tvShowDescription,
                genres = tvShowAllDetails.genres,
                voteAverage = tvShowAllDetails.voteAverage,
                firstAirDate = tvShowAllDetails.firstAirDate,
                topCast = tvShowAllDetails.topCast.map { it.toTvShowTopCastUiState() },
                keywords = tvShowAllDetails.keywords,
                seasons = tvShowAllDetails.seasons.map { it.toSeasonUiState() },
                reviews = tvShowAllDetails.reviews.map { it.toTvShowReviewUiState() },
                posters = tvShowAllDetails.posters,
                recommendations = tvShowAllDetails.recommendations.map { it.toTvShowRecommendationUiState() },
                myRating = 0,
                isLoading = false,
                error = null,
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = error,
            )
        }
    }


    override fun onClickBack() {
        
    }

    override fun onClickFavorite(seriesId: Int) {
        
    }

    override fun onClickSave(seriesId: Int) {
        
    }

    override fun onClickPlayTrailer(seriesUrl: String) {
        
    }

    override fun onClickCategory(genre: String) {
        
    }

    override fun onClickRateSeries(seriesId: Int, rate: Double) {
        
    }

    override fun onClickTopCastSeeAll() {
        
    }

    override fun onClickCast(castId: Int) {
        
    }

    override fun onClickKeyword(seriesId: Int) {
        
    }

    override fun onClickSeasonSeaAll() {
        
    }

    override fun onClickSeason(seriesId: Int, seasonId: Int) {
        
    }

    override fun onClickPosterSeaAll() {
        
    }

    override fun onClickPoster(seriesId: Int, seasonNumber: Int) {
        
    }

    override fun onClickReviewsSeeAll() {
        
    }

    override fun onClickReview(reviewId: Int) {

    }

    override fun onClickRecommendationsSeriesSeeAll() {
        
    }

    override fun onClickRecommendation(seriesId: Int) {
        
    }

}