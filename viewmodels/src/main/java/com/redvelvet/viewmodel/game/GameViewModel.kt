package com.redvelvet.viewmodel.game

import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(

): BaseViewModel<GameUiState, Unit>(GameUiState()) {

}