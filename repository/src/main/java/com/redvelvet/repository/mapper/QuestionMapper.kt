package com.redvelvet.repository.mapper

import com.redvelvet.entities.Question
import com.redvelvet.repository.dto.QuestionDto

fun QuestionDto.toEntity(): Question{
    val correctAnswerValue: String = this.correctAnswer ?: ""

    val answers: List<String> = incorrectAnswers?.takeIf { it.isNotEmpty() }
        ?.toMutableList()?.apply { add(correctAnswerValue) }
        ?.filterNotNull()?.shuffled()
        ?: emptyList()

    return Question(
        question = this.question?.text ?: "",
        answers = answers,
        correctAnswer = this.correctAnswer ?: ""
    )
}