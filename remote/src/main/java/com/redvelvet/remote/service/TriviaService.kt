package com.redvelvet.remote.service

import com.redvelvet.repository.dto.QuestionDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaService {

    @GET("questions")
    suspend fun getQuestions(
        @Query("tags") tags: String,
        @Query("categories") categories: String = "film_and_tv"
    ): Response<List<QuestionDto>>

    companion object{
        const val MOVIE = "film"
        const val TV = "tv"
        const val ACTING = "acting"
    }

}