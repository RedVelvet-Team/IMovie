package com.redvelvet.repository.mapper

import com.redvelvet.entities.library.CreateList
import com.redvelvet.entities.library.StatusEntity
import com.redvelvet.repository.dto.library.response.CreateListResponseDto
import com.redvelvet.repository.dto.tvShow.StatusResponseDto

fun CreateListResponseDto.toCreateList(): CreateList {
    return CreateList(
        status_code = this.status_code,
        status_message = this.status_message,
        success = this.success,
        list_id = this.list_id
    )
}

fun StatusResponseDto.toStatusEntity(): StatusEntity {
    return StatusEntity(
        statusCode = this.statusCode ?: 0,
        statusMessage = this.statusMessage ?: " ",
        success = this.success
    )
}