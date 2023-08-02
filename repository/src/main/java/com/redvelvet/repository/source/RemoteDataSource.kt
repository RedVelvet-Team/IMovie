package com.redvelvet.repository.source

import com.redvelvet.repository.dto.auth.response.GuestSessionDto

interface RemoteDataSource {
    suspend fun createGuestSession(): GuestSessionDto
}