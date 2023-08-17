package com.redvelvet.viewmodel.movieDetails

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.entities.tv.TvShowAllDetails
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.seeall.movie.SeeAllMovieArgs
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.tvshow.toSeasonUiState
import com.redvelvet.viewmodel.tvshow.toTvShowRecommendationUiState
import com.redvelvet.viewmodel.tvshow.toTvShowReviewUiState
import com.redvelvet.viewmodel.tvshow.toTvShowTopCastUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getMovieFullDetails: GetMovieFullDetailsUseCase
) : BaseViewModel<MovieDetailsScreenUiState, MovieDetailsUiEvent>(MovieDetailsScreenUiState()),
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
                isLoading = false
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

    override fun onClickFavorite(movieId: Int, mediaType: String) {

    }

    override fun onClickSave(movieId: Int) {

    }

    override fun onClickPlayTrailer(movieUrl: String) {

    }

    override fun onClickGenre(genre: String) {

    }

    override fun onClickRateMovie(movieId: Int, rate: Double) {

    }

    override fun onClickTopCastSeeAll() {

    }

    override fun onClickCast(castId: Int) {

    }

    override fun onClickKeyword(keywordId: Int) {

    }

    override fun onClickSimilarMoviesSeeAll() {

    }

    override fun onClickMovie(movieId: Int) {

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

    }
}