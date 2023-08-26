package com.redvelvet.viewmodel.game

import com.redvelvet.entities.Question
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class GameUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val question: QuestionUiState = QuestionUiState()
): BaseUiState


data class QuestionUiState(
    val number: Int = 0,
    val question: String = "",
    val answers: List<AnswerUiState> = emptyList(),
    val questionScore: String = "",
)
data class AnswerUiState(
    val isCorrect: Boolean = false,
    val text: String = ""
)

fun Question.toUiState() = QuestionUiState(
    number = 0,
    question = this.question,
    answers = this.answers.map { AnswerUiState(text = it) }
)