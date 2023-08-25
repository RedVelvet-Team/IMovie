package com.redvelvet.repository.dto.detailsRequests

import com.google.gson.annotations.SerializedName

data class RateRequest(
    @SerializedName("value")
    val rate: Double?,
)