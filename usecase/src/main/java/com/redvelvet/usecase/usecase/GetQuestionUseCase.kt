package com.redvelvet.usecase.usecase

import com.redvelvet.entities.Question
import com.redvelvet.usecase.repository.MovieRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class GetQuestionUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    private var questions = listOf<Question>()
    private var questionIndex = 0

    suspend fun getMovieQuestion(): Question {
        if (questions.isEmpty()) {
            questions = repository.getMovieQuestions()
        }
        return questions[questionIndex].also { questionIndex++ }
    }

    suspend fun getTvQuestion(): Question {
        if (questions.isEmpty()) {
            questions = repository.getTvQuestions()
        }
        return questions[questionIndex].also { questionIndex++ }
    }

    fun clearQuestions() {
        questions = listOf<Question>()
        questionIndex = 0
    }

    fun isCorrectAnswer(answer: String) = questions[questionIndex - 1].correctAnswer == answer

    fun areAllQuestionsAnswered() = (questionIndex) >= questions.size

    suspend fun updatePlayerScore(score: Int) {
        repository.savePlayerScore(score)
    }
}