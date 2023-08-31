package com.redvelvet.viewmodel.game

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.Player
import com.redvelvet.entities.error.ValidationException
import com.redvelvet.usecase.usecase.GetPlayerInfoUseCase
import com.redvelvet.usecase.usecase.auth.GetAccountDetailsUsecase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getPlayerInfo: GetPlayerInfoUseCase,
    private val getAccountDetails: GetAccountDetailsUsecase,

    ) : BaseViewModel<GameScoreUiState, GameScoreUiEffect>(GameScoreUiState()) {

    private val args = GameArgs(savedStateHandle)
    private fun onCheckAccountDetailsIsSaved(isUserDetailsSaved: Boolean) {
        Log.e("hass", "isUserDetailsSaved$isUserDetailsSaved")
    }

    private fun onCheckAccountDetailsNotSaved(error: ErrorUiState) {
        Log.e("hass", "error${error.message}")
    }

    init {
        tryToExecute(
            execute = getAccountDetails::invoke,
            onSuccessWithData = ::onCheckAccountDetailsIsSaved,
            onError = ::onCheckAccountDetailsNotSaved,
        )

        _state.update { it.copy(type = enumValueOf(args.media)) }
        getPlayerScore()
        getHighestPlayerScore()
    }

    private fun getPlayerScore() {
        tryToExecute(
            execute = { getPlayerInfo.getPlayerScore() },
            onSuccessWithData = ::onGetPlayerInfoScoreSuccess,
            onError = ::onError
        )
    }

    private fun getHighestPlayerScore() {
        tryToExecute(
            execute = { getPlayerInfo.getHighestScorePlayer() },
            onSuccessWithData = ::onGetHighestPlayerInfoScoreSuccess,
            onError = ::onError
        )
    }

    private fun onGetPlayerInfoScoreSuccess(player: Player) {
        _state.update { it.copy(userInfo = player.toUiState()) }
    }

    private fun onGetHighestPlayerInfoScoreSuccess(players: List<Player>) {
        _state.update {
            it.copy(
                highestScorePlayer = players.map { it.toUiState() },
                isLoading = false
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update { it.copy(error = error) }
    }

    fun onClickCancel() {
        _state.update { it.copy(canJoinGame = true) }
    }

    fun onClickPlay() {
        viewModelScope.launch {
            try {
                getPlayerInfo.addPlayer()
                sendUiEffect(GameScoreUiEffect.NavigateToQuestionsScreen)
            } catch (e: ValidationException) {
                _state.update { it.copy(canJoinGame = false) }
            } catch (e: Exception) {
                onError(ErrorUiState(e.message.toString()))
            }
        }
    }
}