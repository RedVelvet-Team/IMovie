package com.redvelvet.repository.source

import com.redvelvet.repository.dto.auth.response.GuestSessionDto
import com.redvelvet.repository.dto.auth.response.SessionDto
import com.redvelvet.repository.dto.auth.response.TokenDto

interface RemoteDataSource {
    suspend fun createGuestSession(): GuestSessionDto
    suspend fun createToken(): TokenDto
    suspend fun validateUserWithLogin(userName:String,password:String):TokenDto
    suspend fun createUserSession(): SessionDto
    suspend fun deleteUserSession(): SessionDto
}