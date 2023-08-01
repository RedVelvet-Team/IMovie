package com.redvelvet.repository.dto

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val error: ErrorResponseDto) : ApiResponse<Nothing>()
}