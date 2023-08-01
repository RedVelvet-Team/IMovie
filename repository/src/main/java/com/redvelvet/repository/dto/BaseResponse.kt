package com.redvelvet.repository.dto

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    val page: Int?,
    @SerializedName("results")
    val result: T?,
    val totalPages: Int? = 0,
    @SerializedName("total_results")
    val totalResults: Int? = 0
)
