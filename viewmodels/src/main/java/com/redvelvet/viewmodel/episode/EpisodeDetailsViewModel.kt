package com.redvelvet.viewmodel.episode

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.episode.EpisodeDetails
import com.redvelvet.usecase.usecase.auth.GetUserSessionIdUseCase
import com.redvelvet.usecase.usecase.episode.GetEpisodeDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getEpisodeDetailsUseCase: GetEpisodeDetailsUseCase,
    private val getUserSessionIdUseCase: GetUserSessionIdUseCase
) : BaseViewModel<EpisodeDetailsUiState, EpisodeDetailsUiEffect>(EpisodeDetailsUiState()) {

    private val args: EpisodeDetailsArgs = EpisodeDetailsArgs(savedStateHandle = savedStateHandle)

    init {
        getData()
    }

    private fun getData() {
//        tryToExecute(
//            execute = { getEpisodeDetailsUseCase(
//                tvId = args.tvId,
//                seasonNumber = args.seasonId,
//                episodeNumber = args.episodeId,
//                sessionId = "c6318ed5d979bdec77cbb027a0cbaa3ef8f8df34"//getUserSessionIdUseCase()
//            ) },
//            onSuccessWithData = ::onSuccess,
//            onError = ::onError,
//        )
        tryToExecute(
            execute = {
                getEpisodeDetailsUseCase(
                    tvId = 1396,
                    seasonNumber = 1,
                    episodeNumber = 1,
                    sessionId = "c6318ed5d979bdec77cbb027a0cbaa3ef8f8df34"
                )
            },
            onSuccessWithData = ::onSuccess,
            onError = ::onError,
        )
    }

    private fun onSuccess(episodeDetails: EpisodeDetails) {
        _state.update {
            EpisodeDetailsUiState(
                data = episodeDetails.toUiState(),
                isLoading = false,
                isError = null,
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = error,
            )
        }
    }
}