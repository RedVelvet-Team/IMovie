package com.redvelvet.repository.source

import com.redvelvet.repository.dto.ApiResponse
import com.redvelvet.repository.dto.auth.TokenDto
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getNewRequestToken(): Response<TokenDto>
}