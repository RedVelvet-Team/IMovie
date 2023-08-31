package com.redvelvet.repository.dto.library.list


import com.google.gson.annotations.SerializedName

data class CreatedListsDto(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
) {
    data class Result(
        @SerializedName("description")
        val description: String?,
        @SerializedName("favorite_count")
        val favoriteCount: Int?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("item_count")
        val itemCount: Int?,
        @SerializedName("iso_639_1")
        val iso6391: String?,
        @SerializedName("list_type")
        val listType: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("poster_path")
        val posterPath: String?
    )
}