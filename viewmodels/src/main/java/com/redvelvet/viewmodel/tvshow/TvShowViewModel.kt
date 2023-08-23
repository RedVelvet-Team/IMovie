package com.redvelvet.viewmodel.tvshow


import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.tv.TvShowAllDetails
import com.redvelvet.usecase.usecase.tvshow.GetAllTvShowDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getTvShSowDetails: GetAllTvShowDetailsUseCase,
) : BaseViewModel<SeriesDetailsUiState, TvShowUiEffect>(SeriesDetailsUiState()),
    TvShowDetailsInteraction {

    private val args: TvDetailsArgs = TvDetailsArgs(savedStateHandle)

    init {
        getData()
    }

    fun refresh() {
        getData()
    }

    private fun getData() {
        tryToExecute(
            execute = { getTvShSowDetails(args.id.toInt()) },
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
                videos = tvShowAllDetails.videos.map { it.toTvShowVideoUiState() },
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

    override fun onClickTopCastSeeAll(id: String) {
        sendUiEffect(TvShowUiEffect.NavigateToTopCastSeeAllScreen(id))
    }

    override fun onClickCast(castId: Int) {
        sendUiEffect(TvShowUiEffect.NavigateToActorDetailsScreen(castId.toString()))
    }

    override fun onClickKeyword(seriesId: Int) {

    }

    override fun onClickSeasonSeaAll(seriesId: String) {
        sendUiEffect(TvShowUiEffect.NavigateToSeasonSeeAllScreen(seriesId))
    }

    override fun onClickSeason(seriesId: String, seasonId: Int) {
        sendUiEffect(TvShowUiEffect.NavigateToSeasonDetailsScreen(seriesId, seasonId))
    }

    override fun onClickPosterSeaAll(seriesId: String) {
        sendUiEffect(TvShowUiEffect.NavigateToTvShowPosterSeeAllScreen(seriesId))
    }

    override fun onClickPoster(seriesId: Int, seasonNumber: Int) {

    }

    override fun onClickReviewsSeeAll(seriesId: String) {
        sendUiEffect(TvShowUiEffect.NavigateToReviewSeeAllScreen(seriesId))
    }

    override fun onClickReview(reviewId: String) {

    }

    override fun onClickRecommendationsSeriesSeeAll(seriesId: String) {
        sendUiEffect(TvShowUiEffect.NavigateToTvShowRecommendationSeeAllScreen(seriesId))
    }

    override fun onClickSeries(seriesId: String) {
        sendUiEffect(TvShowUiEffect.NavigateToTvShowDetails(seriesId))
    }

}