package com.redvelvet.usecase.usecase

import com.redvelvet.entities.Question
import com.redvelvet.usecase.repository.MovieRepository
import javax.inject.Inject

class GetQuestionUseCase @Inject constructor(
   private val repository: MovieRepository
) {
    private var questions = listOf<Question>()
    private var questionIndex = 0

    suspend fun getMovieQuestion(): Question{
        if (questions.isEmpty()){
            questions = repository.getMovieQuestions()
        }
        return questions[questionIndex].also { questionIndex++ }
    }

    suspend fun getTvQuestion(): Question{
        if (questions.isEmpty()){
            questions = repository.getTvQuestions()
        }
        return questions[questionIndex].also { questionIndex++ }
    }
    suspend fun getActingQuestion(): Question{
        if (questions.isEmpty()){
            questions = repository.getActingQuestions()
        }
        return questions[questionIndex].also { questionIndex++ }
    }

    fun isCorrectAnswer(answer: String) = questions[questionIndex - 1].correctAnswer == answer

    fun isQuestionsEnded() = (questionIndex - 1)  >= questions.size
}