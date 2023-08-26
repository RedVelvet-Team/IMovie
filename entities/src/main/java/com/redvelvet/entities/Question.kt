package com.redvelvet.entities

data class Question(
    val question: String,
    val answers: List<String>,
    val correctAnswer: String,
)