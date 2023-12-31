package com.redvelvet.viewmodel.seeall.tv

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.usecase.seealltv.GetAllTvSeriesUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.SeeAllTvShows
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllTvViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAllSeries: GetAllTvSeriesUseCase
) : BaseViewModel<SeeAllTvShowUiState, Unit>(SeeAllTvShowUiState()) {
    private val args: SeeAllTvArgs = SeeAllTvArgs(savedStateHandle)

    init {
        when (args.type) {
            SeeAllTvShows.POPULAR.name -> {
                _state.update { it.copy(title = "Popular Series") }
                getPopular()
            }

            SeeAllTvShows.AIRING_TODAY.name -> {
                _state.update { it.copy(title = "Airing Today") }
                getAiringTodayTv()
            }

            SeeAllTvShows.ON_TV.name -> {
                _state.update { it.copy(title = "On TV") }
                getOnTheAir()
            }

            SeeAllTvShows.TOP_RATED.name -> {
                _state.update { it.copy(title = "Top Rated") }
                getTopRated()
            }
            SeeAllTvShows.RECOMMEND.name ->{
                _state.update { it.copy(title = "Recommendation") }
                getRecommended()
            }
        }
    }

    private fun getTopRated() {
        tryToExecutePaging(
            call = { getAllSeries.getTopRatedTv() },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun getRecommended() {
        tryToExecutePaging(
            call = { getAllSeries.getRecommendedTv(args.id?.toInt() ?: 0) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun getPopular() {
        tryToExecutePaging(
            call = { getAllSeries.getPopularTv().cachedIn(viewModelScope) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun getOnTheAir() {
        tryToExecutePaging(
            call = { getAllSeries.getOnTheAir().cachedIn(viewModelScope) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun getAiringTodayTv() {
        tryToExecutePaging(
            call = { getAllSeries.getAiringTodayTv().cachedIn(viewModelScope) },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    private fun onSuccess(result: PagingData<TvShow>) {
        _state.update {
            it.copy(
                isLoading = false,
                tvShows = flowOf(result.map { tvShow -> tvShow.toTvShowUiState() }),
                error = null
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                error = error
            )
        }
    }

}