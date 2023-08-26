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

    private var questions = listOf<Pair<String, List<String>>>()

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
        _state.update {
            it.copy(isLoading = false, question = question.toUiState()) }
    }

    private fun onError(error: ErrorUiState) {
        _state.update { it.copy(isLoading = false, error = error) }
    }

    fun onClickAnswer(answer: AnswerUiState): Boolean {
       return getQuestion.isCorrectAnswer(answer.text).also { getQuestion() }
    }
}