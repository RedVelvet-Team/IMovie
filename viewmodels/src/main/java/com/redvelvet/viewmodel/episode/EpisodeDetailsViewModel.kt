package com.redvelvet.viewmodel.episode

import android.util.Log
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
) : BaseViewModel<EpisodeDetailsUiState, EpisodeDetailsUiEffect>(EpisodeDetailsUiState()),
    EpisodeDetailsInteraction {

    private val args: EpisodeDetailsArgs = EpisodeDetailsArgs(savedStateHandle = savedStateHandle)


    init {
        getData()
    }

    override fun onClickBack() {
        sendUiEffect(EpisodeDetailsUiEffect.NavigateUp)
    }

    override fun onClickFavorite(episodeID: String) {
        /*TODO("Not yet implemented")*/
    }

    override fun onClickSave(episodeID: String) {
        /*TODO("Not yet implemented")*/
    }

    override fun onClickTopCastSeeAll(topCastId: String) {
        sendUiEffect(EpisodeDetailsUiEffect.NavigateToSeeAllCastDetailsScreen(topCastId))
    }

    override fun onCLickImagesSeeAll(imagesId: String) {
        sendUiEffect(EpisodeDetailsUiEffect.NavigateToSeeAllImagesScreen(imagesId))
    }

    override fun onClickCast(castId: String) {
        sendUiEffect(EpisodeDetailsUiEffect.NavigateToCastDetailsScreen(castId))
    }

    override fun onClickVideo(videoKey: String) {
        sendUiEffect(EpisodeDetailsUiEffect.NavigateToVideoScreen(videoKey))
    }

    override fun onClickImage(imageId: String) {
        sendUiEffect(EpisodeDetailsUiEffect.NavigateToImageScreen(imageId))
    }

    override fun onCLickRefresh() {
        getData()
    }

    private fun getData() {
        tryToExecute(
            execute = {
                getEpisodeDetailsUseCase(
                    tvId = args.tvId,
                    seasonNumber = args.seasonId,
                    episodeNumber = args.episodeId,
                    sessionId = getUserSessionIdUseCase()
                )
            },
            onSuccessWithData = ::onSuccess,
            onError = ::onError,
        )
    }

    private fun onSuccess(episodeDetails: EpisodeDetails) {
        Log.i("abaferas", episodeDetails.toString())
        _state.update {
            EpisodeDetailsUiState(
                data = episodeDetails.toUiState(),
                isLoading = false,
                isError = null,
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        Log.i("abaferas", error.message)
        _state.update {
            it.copy(
                isLoading = false,
                isError = error,
            )
        }
    }
}

