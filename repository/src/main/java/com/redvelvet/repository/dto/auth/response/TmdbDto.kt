package com.redvelvet.repository.dto.auth.response

import com.google.gson.annotations.SerializedName

data class TmdbDto(
    @SerializedName("avatar_path")
    val avatarPath: Any
)