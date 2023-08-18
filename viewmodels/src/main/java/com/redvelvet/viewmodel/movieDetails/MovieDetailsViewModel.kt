package com.redvelvet.viewmodel.movieDetails

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.movie.details.MovieFullDetails
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
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

    fun refresh() {
        getData()
    }
}