package com.redvelvet.repository.mapper

import com.redvelvet.entities.user.User
import com.redvelvet.repository.dto.auth.response.UserDetailsDto

fun UserDetailsDto.toUserEntity(): User{
    return User(
        id = id ?: 0,
        userName = username.orEmpty(),
        image = avatar?.tmdb?.avatarPath.toString(),
    )
}