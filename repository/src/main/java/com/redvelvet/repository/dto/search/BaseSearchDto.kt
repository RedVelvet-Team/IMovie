package com.redvelvet.repository.dto.search

import com.google.gson.annotations.SerializedName

data class BaseSearchDto(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val searchResultDtos: List<SearchResultDto?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)