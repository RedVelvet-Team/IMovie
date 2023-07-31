package com.redvelvet.remote.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse<T>(
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("status_code")
    val code: Int?,
    @SerializedName("status_message")
    val message: String?,
    @SerializedName("value")
    val value: T
)
