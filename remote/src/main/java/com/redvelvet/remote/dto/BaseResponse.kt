package com.redvelvet.remote.dto

import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status_message")
    val statusMessage: String?,
    @SerializedName("success")
    val success: Boolean?,
    @SerializedName("list_id")
    val listId: Int?
)