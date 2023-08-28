package com.redvelvet.viewmodel.game

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.LOGGER
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
class GameViewModel @Inject constructor(
    private val getQuestion: GetQuestionUseCase
) : BaseViewModel<GameUiState, Unit>(GameUiState()) {

    init {
        getQuestion()
    }

    private fun getQuestion() {
        viewModelScope.launch {
            delay(1000)
            tryToExecute(
                execute = { getQuestion.getMovieQuestion() },
                onSuccessWithData = ::onGetQuestionSuccess,
                onError = ::onError
            )
        }
    }

    private fun onGetQuestionSuccess(question: Question) {
        val currentQuestion = _state.value.number
        val questionNumber = _state.value.currentQuestionNumber
        currentQuestion[questionNumber] =
            QuestionNumberState(questionNumber + 1, Correctness.CURRENT_ANSWERED)
        _state.update {
            it.copy(
                isLoading = false,
                question = question.toUiState(),
                isAnswered = false,
                number = currentQuestion,
                currentQuestionNumber = questionNumber + 1
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update { it.copy(isLoading = false, error = error) }
    }

    fun onClickAnswer(answer: AnswerUiState): Boolean {

        val currentQuestion = _state.value.number
        val questionNumber = _state.value.currentQuestionNumber
        val isCorrectAnswer = getQuestion.isCorrectAnswer(answer.text)
        currentQuestion[questionNumber-1] =
            QuestionNumberState(questionNumber, if (isCorrectAnswer) Correctness.CORRECT else Correctness.WRONG)
        _state.update { it.copy(isAnswered = true, number = currentQuestion) }
        Log.v("hass", getQuestion.isQuestionsEnded().toString())
        return isCorrectAnswer.also {
            if (getQuestion.isQuestionsEnded()) {
                _state.update { it.copy(isGameFinished = true) }
            } else {
                getQuestion()
            }
        }
    }
}