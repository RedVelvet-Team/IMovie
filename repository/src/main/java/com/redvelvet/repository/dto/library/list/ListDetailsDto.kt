package com.redvelvet.repository.dto.library.list


import com.google.gson.annotations.SerializedName

data class ListDetailsDto(
    @SerializedName("created_by")
    val createdBy: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("favorite_count")
    val favoriteCount: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("items")
    val items: List<Any>,
    @SerializedName("item_count")
    val itemCount: Int?,
    @SerializedName("iso_639_1")
    val iso6391: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("poster_path")
    val posterPath: String?
)