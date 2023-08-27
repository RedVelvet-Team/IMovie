package com.redvelvet.viewmodel.game

import android.util.Log
import androidx.paging.LOGGER
import com.redvelvet.entities.Player
import com.redvelvet.usecase.usecase.GetPlayerInfoUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GameScoreViewModel @Inject constructor(
    private val getPlayerInfo: GetPlayerInfoUseCase
): BaseViewModel<GameScoreUiState, Unit>(GameScoreUiState()) {
    init {
        getPlayerScore()
        getHighestPlayerScore()
    }

    private fun getPlayerScore(){
        tryToExecute(
            execute = {getPlayerInfo.getPlayerScore()},
            onSuccessWithData = ::onGetPlayerInfoScoreSuccess,
            onError = ::onError
        )
    }

    private fun getHighestPlayerScore(){
        tryToExecute(
            execute = {getPlayerInfo.getHighestScorePlayer()},
            onSuccessWithData = ::onGetHighestPlayerInfoScoreSuccess,
            onError = ::onError
        )
    }

    private fun onGetPlayerInfoScoreSuccess(player: Player){
        _state.update { it.copy(userInfo = player.toUiState()) }
    }
    private fun onGetHighestPlayerInfoScoreSuccess(players: List<Player>){
        Log.v("hass", players.toString())
        _state.update { it.copy(highestScorePlayer = players.map { it.toUiState() }, isLoading = false) }
    }

    private fun onError(error: ErrorUiState){
        _state.update { it.copy(error = error) }
    }
}