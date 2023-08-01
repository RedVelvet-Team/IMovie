package com.redvelvet.repository.dto

import com.google.gson.annotations.SerializedName

data class ErrorResponseDto(
    val success: Boolean?,
    @SerializedName("status_code")
    val code: Int?,
    @SerializedName("status_message")
    val message: String?,
)
