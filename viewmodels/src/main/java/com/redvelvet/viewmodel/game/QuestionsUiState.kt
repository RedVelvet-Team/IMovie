package com.redvelvet.viewmodel.game

import com.redvelvet.entities.Question
import com.redvelvet.viewmodel.base.BaseUiState
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.utils.MediaType

data class QuestionsUiState(
    val isLoading: Boolean = true,
    val isGameFinished: Boolean = false,
    val error: ErrorUiState? = null,
    val type: MediaType = MediaType.MOVIE,
    val currentQuestionNumber: Int = 0,
    val question: QuestionUiState = QuestionUiState(),
    val isAnswered: Boolean = false,
    val currentScore: Int = 0,
    val questionNumberList: MutableList<QuestionNumberState> = MutableList(10) {
        QuestionNumberState(
            number = it + 1
        )
    }
) : BaseUiState

data class QuestionUiState(
    val score: String = "",
    val text: String = "",
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

enum class Correctness {
    CORRECT,
    WRONG,
    NOT_ANSWERED,
    CURRENT_ANSWERED
}

fun Question.toUiState() = QuestionUiState(
    text = this.question,
    answers = this.answers.map { AnswerUiState(text = it) },
    score = this.score.toString()
)