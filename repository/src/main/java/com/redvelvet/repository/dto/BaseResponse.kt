package com.redvelvet.repository.dto

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    val success: Boolean?,
    @SerializedName("status_code")
    val code: Int?,
    @SerializedName("status_message")
    val message: String?,
    val page: Int?,
    val results: T?,
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)
