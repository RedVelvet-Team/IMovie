package com.redvelvet.repository.mapper

import com.redvelvet.entities.user.AccountDetails
import com.redvelvet.repository.dto.auth.response.AccountDetailsDto

fun AccountDetailsDto.toDomain(): AccountDetails {
    return AccountDetails(
        id, name, username
    )
}
