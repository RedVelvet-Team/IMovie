package com.redvelvet.viewmodel.game

import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class GameUiState(
    val number: String = "",
    val question: String = "",
    val answers: List<AnswerUiState> = emptyList(),
    val questionScore: String = "",
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null
): BaseUiState


data class AnswerUiState(
    val isCorrect: Boolean = false,
    val text: String = ""
)