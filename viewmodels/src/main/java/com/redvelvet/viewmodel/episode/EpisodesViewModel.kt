package com.redvelvet.viewmodel.episode

import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.usecase.usecase.GetAllEpisodesUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.seeall.episode.EpisodeUiState
import com.redvelvet.viewmodel.seeall.episode.EpisodesUiEffect
import com.redvelvet.viewmodel.seeall.episode.toEpisodeCardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase
) : BaseViewModel<EpisodeUiState, EpisodesUiEffect>(EpisodeUiState()) {

    init {
        getAllEpisodes("100", 1)
    }

    private fun getAllEpisodes(tvId: String, seasonNumber: Int) {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            execute = { getAllEpisodesUseCase(tvId = tvId, seasonNumber = seasonNumber) },
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