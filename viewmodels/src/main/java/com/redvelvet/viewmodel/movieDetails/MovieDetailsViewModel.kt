package com.redvelvet.viewmodel.movieDetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.usecase.usecase.detailsActions.AddMovieRatingUseCase
import com.redvelvet.usecase.usecase.detailsActions.DeleteMovieRatingUseCase
import com.redvelvet.usecase.usecase.detailsActions.ToggleMediaInFavoritesUsecase
import com.redvelvet.usecase.usecase.detailsActions.ToggleMediaInWatchListUsecase
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieFullDetails: GetMovieFullDetailsUseCase,
    private val addMovieRating: AddMovieRatingUseCase,
    private val deleteMovieRating: DeleteMovieRatingUseCase,
    private val toggleMediaInFavorites: ToggleMediaInFavoritesUsecase,
    private val toggleMediaInWatchList: ToggleMediaInWatchListUsecase,


    ) : BaseViewModel<MovieDetailsScreenUiState, MovieDetailsUiEffect>(MovieDetailsScreenUiState()),
    MovieDetailsInteraction {

    private val args: MovieDetailsArgs = MovieDetailsArgs(savedStateHandle)

    init {
        getData()
    }


    private fun getData() {
        tryToExecute(
            execute = { getMovieFullDetails(args.id.toInt()) },
            onSuccessWithData = ::onSuccess,
            onError = ::onError,
        )
    }

    private fun onSuccess(movieAllDetails: MovieFullDetails) {
        _state.update {
            MovieDetailsScreenUiState(
                data = movieAllDetails.toMovieFullDetailsScreenUiState(),
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

    override fun onClickFavorite(movieId: Int, mediaType: String) {
        _state.update {
            it.copy(
                favoriteActionState = MovieDetailsScreenUiState.FavoriteActionUiState(
                    isLoading = true
                )
            )
        }
        tryToExecute(
            execute = {
                toggleMediaInFavorites(
                    mediaType = "movie",
                    mediaId = movieId,
                    isSavedInFavorites = true
                )
            },
            onSuccessWithData = ::onFavoriteSuccess,
            onError = ::onFavoriteError,
        )
    }

    private fun onFavoriteSuccess(response: String) {
        _state.update {
            it.copy(
                favoriteActionState = MovieDetailsScreenUiState.FavoriteActionUiState(
                    isLoading = false,
                    data = response
                )
            )
        }
    }

    private fun onFavoriteError(error: ErrorUiState) {
        _state.update {
            it.copy(
                favoriteActionState = MovieDetailsScreenUiState.FavoriteActionUiState(
                    isLoading = false,
                    error = error
                )
            )
        }
    }


    override fun onClickSave(movieId: Int) {

        _state.update {
            it.copy(
                addToWatchListActionUiState = MovieDetailsScreenUiState.AddToWatchListActionUiState(
                    isLoading = true
                )
            )
        }
        tryToExecute(
            execute = {
                toggleMediaInWatchList(
                    mediaType = "movie",
                    mediaId = movieId,
                    isSavedInWatchList = true
                )
            },
            onSuccessWithData = ::onSaveSuccess,
            onError = ::onSaveError,
        )
    }

    private fun onSaveSuccess(response: String) {
        _state.update {
            it.copy(
                addToWatchListActionUiState = MovieDetailsScreenUiState.AddToWatchListActionUiState(
                    isLoading = false,
                    data = response
                )
            )
        }
    }

    private fun onSaveError(error: ErrorUiState) {
        _state.update {
            it.copy(
                addToWatchListActionUiState = MovieDetailsScreenUiState.AddToWatchListActionUiState(
                    isLoading = false,
                    error = error
                )
            )
        }
    }


    override fun onClickPlayTrailer(movieUrl: String) {

    }

    override fun onClickGenre(genre: String) {

    }

    override fun onClickRateMovie(movieId: Int, rate: Double) {
    }

    override fun onClickTopCastSeeAll() {
        sendUiEffect(MovieDetailsUiEffect.NavigateToTopCastSeeAllScreen)
    }

    override fun onClickCast(castId: Int) {
        sendUiEffect(MovieDetailsUiEffect.NavigateToTopCastDetailsScreen(castId.toString()))
    }

    override fun onClickSimilarMoviesSeeAll() {
        sendUiEffect(MovieDetailsUiEffect.NavigateToSimilarMoviesSeeAllScreen)

    }

    override fun onClickMovie(movieId: Int) {
        sendUiEffect(MovieDetailsUiEffect.NavigateToMovieDetailsScreen(movieId.toString()))
    }

    override fun onClickMovieImagesSeeAll() {

    }

    override fun onClickPreviewImage(movieImageId: Int) {

    }

    override fun onClickReviewsSeeAll() {

    }

    override fun onClickReview(reviewId: Int) {

    }

    override fun onClickRecommendationsMoviesSeeAll() {
        sendUiEffect(MovieDetailsUiEffect.NavigateToRecommendedMoviesSeeAllScreen)

    }

    fun refresh() {
        getData()
    }
}