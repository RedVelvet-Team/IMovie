package com.redvelvet.viewmodel.game

import com.redvelvet.entities.Question
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState

data class GameUiState(
    val isLoading: Boolean = true,
    val isGameFinished: Boolean = false,
    val error: ErrorUiState? = null,
    val currentQuestionNumber: Int = 0,
    val question: QuestionUiState = QuestionUiState(),
    val number: MutableList<QuestionNumberState> = MutableList(10) {QuestionNumberState(number = it  +1)},
    val isAnswered: Boolean = false,
    val currentScore: Int = 0
): BaseUiState

data class QuestionUiState(
    val score: String = "",
    val question: String = "",
    val answers: List<AnswerUiState> = emptyList(),
)
data class AnswerUiState(
    val isCorrect: Boolean = false,
    val text: String = ""
)

data class QuestionNumberState(
    val number: Int = 1,
    val correctness: Correctness = Correctness.NOT_ANSWERED
)

enum class Correctness{
    CORRECT,
    WRONG,
    NOT_ANSWERED,
    CURRENT_ANSWERED
}

fun Question.toUiState() = QuestionUiState(
    question = this.question,
    answers = this.answers.map { AnswerUiState(text = it) },
    score = this.score.toString()
)