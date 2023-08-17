package com.redvelvet.viewmodel.seeall.seasons

import android.util.Log
import com.redvelvet.entities.tv.SeasonTvShow
import com.redvelvet.usecase.usecase.seeall.GetAllSeasonsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllSeasonsViewModel @Inject constructor(
    private val getAllSeasonsUseCase: GetAllSeasonsUseCase
) : BaseViewModel<SeeAllSeasonsUiState, SeasonsUiEffect>(SeeAllSeasonsUiState()) {

    init {
        getAllSeasons(2000)
    }

    private fun getAllSeasons(seriesId: Int) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            execute = { getAllSeasonsUseCase(seriesId = seriesId) },
            onSuccessWithData = ::onGetAllSeasonsOnSuccess,
            onError = ::onGetAllSeasonsOnError
        )
    }

    private fun onGetAllSeasonsOnSuccess(season: List<SeasonTvShow>) {
        _state.update {
            it.copy(
                isLoading = false,
                seasons = season.map { it.toSeasonUiState() })
        }
        Log.e("Amna", _state.value.seasons.toString())

    }

    private fun onGetAllSeasonsOnError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }

    }
}