package com.redvelvet.repository.mapper

import com.redvelvet.entities.auth.Guest
import com.redvelvet.repository.dto.auth.response.GuestSessionDto

fun GuestSessionDto.toGuest() = Guest(
    expiresAt = expiresAt,
    guestSessionId = guestSessionId,
    success = success,
)