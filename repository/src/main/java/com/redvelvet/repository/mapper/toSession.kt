package com.redvelvet.repository.mapper

import com.redvelvet.entities.auth.Session
import com.redvelvet.repository.dto.auth.response.SessionDto

fun SessionDto.toSession() = Session(
    sessionId = sessionId,
    success = success,
)