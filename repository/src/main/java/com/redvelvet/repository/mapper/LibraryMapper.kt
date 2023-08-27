package com.redvelvet.repository.mapper

import com.redvelvet.entities.library.CreateList
import com.redvelvet.repository.dto.library.response.CreateListResponseDto

fun CreateListResponseDto.toCreateList(): CreateList {
    return CreateList(
        status_code = this.status_code,
        status_message = this.status_message,
        success = this.success,
        list_id = this.list_id
    )
}