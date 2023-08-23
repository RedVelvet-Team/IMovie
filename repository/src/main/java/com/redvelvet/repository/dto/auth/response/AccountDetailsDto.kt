package com.redvelvet.repository.dto.auth.response

import com.google.gson.annotations.SerializedName

data class AccountDetailsDto(
    val avatar: AvatarSto,
    val id: Int,
    @SerializedName("include_adult")
    val includeAdult: Boolean,
    @SerializedName("iso_3166_1")
    val iso31661: String,
    @SerializedName("iso_639_1")
    val iso6391: String,
    val name: String,
    val username: String
)