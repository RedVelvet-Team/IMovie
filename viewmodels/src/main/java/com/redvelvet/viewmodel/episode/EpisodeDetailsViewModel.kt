package com.redvelvet.viewmodel.episode

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.episode.EpisodeDetails
import com.redvelvet.entities.error.MovieException
import com.redvelvet.entities.error.NetworkException
import com.redvelvet.entities.error.NoInternetException
import com.redvelvet.entities.error.NullResultException
import com.redvelvet.entities.error.ValidationException
import com.redvelvet.usecase.usecase.auth.GetUserSessionIdUseCase
import com.redvelvet.usecase.usecase.episode.GetEpisodeDetailsUseCase
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.base.InvalidationErrorState
import com.redvelvet.viewmodel.base.NetworkErrorState
import com.redvelvet.viewmodel.base.NullResultErrorState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getEpisodeDetailsUseCase: GetEpisodeDetailsUseCase,
    private val getUserSessionIdUseCase: GetUserSessionIdUseCase
) : ViewModel() {

    private val args: EpisodeDetailsArgs = EpisodeDetailsArgs(savedStateHandle = savedStateHandle)
    private val _state = MutableStateFlow(EpisodeDetailsUiState())
    val state = _state.asStateFlow()

    init {
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

    fun refresh() {
        getData()
    }


    fun <T> tryToExecute(
        execute: suspend () -> T,
        onSuccessWithData: (T) -> Unit = {},
        onSuccessWithoutData: () -> Unit = {},
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = execute()
                onSuccessWithData(result)
                onSuccessWithoutData()
            } catch (e: ValidationException) {
                onError(InvalidationErrorState(e.message.toString()))
            } catch (e: NullResultException) {
                onError(NullResultErrorState(e.message.toString()))
            } catch (e: NetworkException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: MovieException) {
                onError(ErrorUiState(e.message.toString()))
            } catch (e: NoInternetException) {
                onError(NetworkErrorState(e.message.toString()))
            } catch (e: Exception) {
                onError(ErrorUiState(e.message.toString()))
            } catch (e: IllegalStateException) {
                onError(ErrorUiState(e.message.toString()))
            }
        }
    }
}