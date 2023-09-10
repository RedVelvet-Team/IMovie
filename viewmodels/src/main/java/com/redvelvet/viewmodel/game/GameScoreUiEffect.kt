package com.redvelvet.viewmodel.game

sealed class GameScoreUiEffect {
    data object NavigateToQuestionsScreen: GameScoreUiEffect()
}