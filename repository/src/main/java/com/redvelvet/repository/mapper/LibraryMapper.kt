package com.redvelvet.repository.mapper

import com.redvelvet.entities.library.CreateList
import com.redvelvet.entities.library.StatusEntity
import com.redvelvet.repository.dto.library.list.CreateListResponseDto
import com.redvelvet.repository.dto.tvShow.StatusResponseDto

fun CreateListResponseDto.toCreateList(): CreateList {
    return CreateList(
        statusCode = this.statusCode,
        statusMessage = this.statusMessage,
        success = this.success,
        listId = this.listId ?: 0
    )
}

fun StatusResponseDto.toStatusEntity(): StatusEntity {
    return StatusEntity(
        statusCode = this.statusCode ?: 0,
        statusMessage = this.statusMessage ?: " ",
        success = this.success
    )
}