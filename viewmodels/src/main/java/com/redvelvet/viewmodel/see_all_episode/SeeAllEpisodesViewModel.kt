package com.redvelvet.viewmodel.see_all_episode

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.EpisodeDetails
import com.redvelvet.usecase.usecase.GetAllEpisodesUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SeeAllEpisodesViewModel @Inject constructor(
    private val getAllEpisodesUseCase: GetAllEpisodesUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<EpisodeUiState, SeeAllEpisodesUiEffect>(EpisodeUiState()),
    SeeAllEpisodesInteractionListener {

    private val args: EpisodesArgs = EpisodesArgs(savedStateHandle)

    init {
        getAllEpisodes()
    }

    private fun getAllEpisodes() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            execute = { getAllEpisodesUseCase(tvId = args.tvId, seasonNumber = args.seasonNumber) },
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

    private fun episode(tvId: Int, seasonId: Int, episodeId: Int, sessionId: String) {
//        _state.update {
//            it.copy(
//                isLoading = true,
//                error = null,
//            )
//        }
//        tryToExecute(
//
//        )
    }

    override fun onClickEpisode() {
//        sendUiEffect(
////            SeeAllEpisodesUiEffect.NavigateToEpisodeDetailsScreen(
////                state.value.episodes., seasonId, episodeId, sessionId
////            )
//        )
    }
}