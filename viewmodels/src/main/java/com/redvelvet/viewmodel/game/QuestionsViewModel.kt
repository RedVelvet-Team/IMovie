package com.redvelvet.viewmodel.game

import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.Question
import com.redvelvet.usecase.usecase.GetQuestionUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(
    private val getQuestion: GetQuestionUseCase
) : BaseViewModel<QuestionsUiState, Unit>(QuestionsUiState()) {

    init {
        getQuestion()
    }

    private fun getQuestion() {
        viewModelScope.launch {
            tryToExecute(
                execute = { getQuestion.getMovieQuestion() },
                onSuccessWithData = ::onGetQuestionSuccess,
                onError = ::onError
            )
        }
    }

    private fun onGetQuestionSuccess(question: Question) {
        val currentQuestionsNumber = _state.value.questionNumberList
        val questionNumber = _state.value.currentQuestionNumber
        currentQuestionsNumber[questionNumber] =
            QuestionNumberState(questionNumber + 1, Correctness.CURRENT_ANSWERED)
        _state.update {
            it.copy(
                isLoading = false,
                question = question.toUiState(),
                isAnswered = false,
                questionNumberList = currentQuestionsNumber,
                currentQuestionNumber = questionNumber + 1
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update { it.copy(isLoading = false, error = error) }
    }

    fun onClickAnswer(answer: AnswerUiState) {
        val isCorrectAnswer = getQuestion.isCorrectAnswer(answer.text)
        updateQuestionNumberSliderState(isCorrectAnswer)
        viewModelScope.launch {
            delay(1000)
            if (getQuestion.areAllQuestionsAnswered()) {
                savePlayerScore()
                _state.update { it.copy(isGameFinished = true) }
            } else {
                getQuestion()
            }
        }
    }

    private fun savePlayerScore() {
        tryToExecute(
            execute = { getQuestion.updatePlayerScore(_state.value.currentScore) },
            onSuccessWithoutData = {},
            onError = ::onError
        )
    }

    private fun updateQuestionNumberSliderState(isCorrectAnswer: Boolean) {
        val currentQuestionsNumber = _state.value.questionNumberList
        val questionNumber = _state.value.currentQuestionNumber

        currentQuestionsNumber[questionNumber - 1] =
            QuestionNumberState(
                questionNumber,
                if (isCorrectAnswer) Correctness.CORRECT else Correctness.WRONG
            )

        _state.update {
            it.copy(
                isAnswered = true,
                questionNumberList = currentQuestionsNumber,
                currentScore = it.currentScore + if (isCorrectAnswer) it.question.score.toInt() else 0
            )
        }
    }
}