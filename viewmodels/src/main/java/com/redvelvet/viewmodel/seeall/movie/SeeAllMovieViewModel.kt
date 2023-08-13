package com.redvelvet.viewmodel.seeall.movie

import androidx.paging.PagingData
import androidx.paging.map
import com.redvelvet.entities.movie.Movie
import com.redvelvet.usecase.usecase.seeall.GetAllMovieUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.onboarding.OnBoardingUiEffect
import com.redvelvet.viewmodel.utils.SeeAllMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllMovieViewModel @Inject constructor(
    private val getAllMovie: GetAllMovieUseCase
): BaseViewModel<SeeAllMovieUiState, OnBoardingUiEffect>(SeeAllMovieUiState()){
    private val args: SeeAllMovie = SeeAllMovie.SIMILAR

    init {
        when(args){
            SeeAllMovie.POPULAR -> {
                _state.update { it.copy(title = "Popular") }
                getPopular()
            }
            SeeAllMovie.NOW_PLAYING -> {
                _state.update { it.copy(title = "Now Playing") }
                getNowPlaying()
            }
            SeeAllMovie.TOP_RATED -> {
                _state.update { it.copy(title = "Top Rated") }
                getTopRated()
            }
            SeeAllMovie.UPCOMING -> {
                _state.update { it.copy(title = "Upcoming") }
                getUpcoming()
            }
            SeeAllMovie.SIMILAR -> {
                _state.update { it.copy(title = "Similar") }
                getSimilar(100)
            }
            SeeAllMovie.RECOMMEND -> {
                _state.update { it.copy(title = "Recommendation") }
                getRecommended(100)
            }
            else -> {}
        }
    }

    private fun getPopular(){
        tryToExecutePaging(
            call = {getAllMovie.getPopular()},
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }

    private fun getUpcoming(){
        tryToExecutePaging(
            call = {getAllMovie.getUpcoming()},
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }

    private fun getTopRated(){
        tryToExecutePaging(
            call = {getAllMovie.getTopRated()},
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }

    private fun getNowPlaying(){
        tryToExecutePaging(
            call = {getAllMovie.getNowPlaying()},
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }

    private fun getSimilar(id: Int){
        tryToExecutePaging(
            call = {getAllMovie.getSimilar(id)},
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }

    private fun getRecommended(id: Int){
        tryToExecutePaging(
            call = {getAllMovie.getRecommended(id)},
            onSuccess = ::onGetSuccess,
            onError = ::onGetError
        )
    }


    private fun onGetSuccess(result: PagingData<Movie>){
        _state.update { it.copy(
            isLoading = false,
            movies = flowOf(result.map { it.toMovieUiState() })
        ) }
    }
    private fun onGetError(error: ErrorUiState){
        _state.update {
            it.copy(
                isLoading = false,
                error = error
            )
        }
    }
}