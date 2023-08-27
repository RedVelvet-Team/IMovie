package com.redvelvet.viewmodel.tvshow


import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.tv.TvShowAllDetails
import com.redvelvet.usecase.usecase.detailsActions.HandleFavoriteUsecase
import com.redvelvet.usecase.usecase.detailsActions.HandleItemCheckUsecase
import com.redvelvet.usecase.usecase.detailsActions.HandleTvRateUsecase
import com.redvelvet.usecase.usecase.detailsActions.HandleWatchlistUsecase
import com.redvelvet.usecase.usecase.tvshow.GetAllTvShowDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.details_ui_states.MediaDetailsScreenUiState
import com.redvelvet.viewmodel.details_ui_states.toUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getTvShSowDetails: GetAllTvShowDetailsUseCase,
    private val handleTvRate: HandleTvRateUsecase,
    private val handleItemCheck: HandleItemCheckUsecase,
    private val handleFavorite: HandleFavoriteUsecase,
    private val handleWatchlist: HandleWatchlistUsecase,
) : BaseViewModel<MediaDetailsScreenUiState, TvShowUiEffect>(MediaDetailsScreenUiState()),
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
            MediaDetailsScreenUiState(
                data = tvShowAllDetails.toUiState(),
                isLoading = false,
                error = null,
                isFavorite = handleItemCheck.isItemInTvList(
                    tvList = tvShowAllDetails.tvFavorites,
                    itemId = tvShowAllDetails.tvShowId,
                ),
                isSavedToList = handleItemCheck.isItemInTvList(
                    tvList = tvShowAllDetails.tvWatchlist,
                    itemId = tvShowAllDetails.tvShowId,
                ),
                isRated = handleItemCheck.isItemInTvList(
                    tvList = tvShowAllDetails.ratedTv,
                    itemId = tvShowAllDetails.tvShowId,
                ),

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


    override fun onClickFavorite(seriesId: Int) {
        _state.update {
            it.copy(
                favoriteActionState = MediaDetailsScreenUiState.FavoriteActionUiState(
                    isLoading = true
                )
            )
        }
        tryToExecute(
            execute = {
                handleFavorite(
                    mediaType = "tv",
                    mediaId = seriesId,
                )
            },
            onSuccessWithData = ::onFavoriteSuccess,
            onError = ::onFavoriteError,
        )
    }

    private fun onFavoriteSuccess(response: String) {
        _state.update {
            it.copy(
                favoriteActionState = MediaDetailsScreenUiState.FavoriteActionUiState(
                    isLoading = false,
                    data = response
                ),
                isFavorite = !response.contains("deleted")
            )
        }
    }

    private fun onFavoriteError(error: ErrorUiState) {
        _state.update {
            it.copy(
                favoriteActionState = MediaDetailsScreenUiState.FavoriteActionUiState(
                    isLoading = false,
                    error = error
                )
            )
        }
    }

    override fun onClickSave(seriesId: Int) {
        _state.update {
            it.copy(
                addToWatchListActionUiState = MediaDetailsScreenUiState.AddToWatchListActionUiState(
                    isLoading = true
                )
            )
        }
        tryToExecute(
            execute = {
                handleWatchlist(
                    mediaType = "tv",
                    mediaId = seriesId,
                )
            },
            onSuccessWithData = ::onSaveSuccess,
            onError = ::onSaveError,
        )
    }

    private fun onSaveSuccess(response: String) {
        _state.update {
            it.copy(
                addToWatchListActionUiState = MediaDetailsScreenUiState.AddToWatchListActionUiState(
                    isLoading = false,
                    data = response
                ),
                isSavedToList = !response.contains("deleted")
            )
        }
    }

    private fun onSaveError(error: ErrorUiState) {
        _state.update {
            it.copy(
                addToWatchListActionUiState = MediaDetailsScreenUiState.AddToWatchListActionUiState(
                    isLoading = false,
                    error = error
                )
            )
        }
    }

    override fun onClickRateSeries(seriesId: Int, rate: Double) {
        _state.update {
            it.copy(
                rateActionUiState = MediaDetailsScreenUiState.RateActionUiState(
                    isLoading = true
                )
            )
        }
        tryToExecute(
            execute = {
                handleTvRate(
                    seriesRating = rate,
                    seriesId = seriesId,
                )
            },
            onSuccessWithData = ::onRateSuccess,
            onError = ::onRateError,
        )

    }

    private fun onRateSuccess(response: String) {
        _state.update {
            it.copy(
                rateActionUiState = MediaDetailsScreenUiState.RateActionUiState(
                    isLoading = false,
                    data = response
                ),
                isRated = !response.contains("deleted")
            )
        }
    }

    private fun onRateError(error: ErrorUiState) {
        _state.update {
            it.copy(
                rateActionUiState = MediaDetailsScreenUiState.RateActionUiState(
                    isLoading = false,
                    error = error
                )
            )
        }
    }


    override fun onClickPlayTrailer(seriesUrl: String) {

    }

    override fun onClickCategory(genre: String) {

    }


    override fun onClickTopCastSeeAll(id: String) {
        sendUiEffect(TvShowUiEffect.NavigateToTopCastSeeAllScreen(id))
    }

    override fun onClickCast(castId: Int) {
        sendUiEffect(TvShowUiEffect.NavigateToActorDetailsScreen(castId.toString()))
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

    override fun onClickRecommendationsSeriesSeeAll(seriesId: String) {
        sendUiEffect(TvShowUiEffect.NavigateToTvShowRecommendationSeeAllScreen(seriesId))
    }

    override fun onClickSeries(seriesId: String) {
        sendUiEffect(TvShowUiEffect.NavigateToTvShowDetails(seriesId))
    }

}