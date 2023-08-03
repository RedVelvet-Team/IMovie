package com.redvelvet.repository.mapper

import com.redvelvet.entities.auth.Token
import com.redvelvet.repository.dto.auth.response.TokenDto

fun TokenDto.toToken() = Token(
    expiresAt = expiresAt,
    requestToken = requestToken,
    success = success,
)