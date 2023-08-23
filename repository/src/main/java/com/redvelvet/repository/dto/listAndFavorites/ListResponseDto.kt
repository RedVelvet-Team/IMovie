package com.redvelvet.repository.dto.listAndFavorites

import com.google.gson.annotations.SerializedName

data class ListResponseDto(
    @SerializedName("list_id")
    val listId: Int? = null,
    @SerializedName("status_code")
    val statusCode: Int? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null,
    @SerializedName("success")
    val success: Boolean? = null
)