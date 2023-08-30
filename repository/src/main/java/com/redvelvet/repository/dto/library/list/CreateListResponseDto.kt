package com.redvelvet.repository.dto.library.list

import com.google.gson.annotations.SerializedName

data class CreateListResponseDto(
    @SerializedName("list_id")
    val listId: Int? = null,
    @SerializedName("status_code")
    val statusCode: Int? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null,
    @SerializedName("success")
    val success: Boolean? = null
)