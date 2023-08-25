package com.redvelvet.viewmodel.episode

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.usecase.usecase.GetAllEpisodesUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.seeall.episode.toEpisodeCardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase,
    savedStateHandle: SavedStateHandle
    ) : BaseViewModel<EpisodeUiState, Unit>(EpisodeUiState()){

    private val args: EpisodesArgs = EpisodesArgs(savedStateHandle)

    init {
        getAllEpisodes()
        _state.update { it.copy(seriesId = args.tvId) }
    }

    private fun getAllEpisodes() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            execute = { getAllEpisodesUseCase(tvId = args.tvId, seasonNumber = args.seasonNumber.toInt()) },
            onSuccessWithData = ::onGetAllEpisodesOnSuccess,
            onError = ::onGetAllEpisodesOnError
        )
    }

    private fun onGetAllEpisodesOnSuccess(episode: List<EpisodeDetails>) {
        _state.update {
            it.copy(
                isLoading = false,
                episodes = episode.map { it.toEpisodeCardUiState() }
            )
        }
    }

    private fun onGetAllEpisodesOnError(errorUiState: ErrorUiState) {
        _state.update { it.copy(error = errorUiState, isLoading = false) }
    }
}