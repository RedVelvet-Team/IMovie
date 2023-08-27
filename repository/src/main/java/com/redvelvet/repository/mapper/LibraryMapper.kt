package com.redvelvet.repository.mapper

import com.redvelvet.entities.library.AddMediaToList
import com.redvelvet.entities.library.CreateList
import com.redvelvet.entities.library.StatusEntity
import com.redvelvet.repository.dto.library.response.CreateListResponseDto
import com.redvelvet.repository.dto.listAndFavorites.AddMediaToListDto
import com.redvelvet.repository.dto.tvShow.StatusResponse

fun CreateListResponseDto.toCreateList(): CreateList {
    return CreateList(
        status_code = this.status_code,
        status_message = this.status_message,
        success = this.success,
        list_id = this.list_id
    )
}

fun StatusResponse.toStatusEntity(): StatusEntity {
    return StatusEntity(
        statusCode = this.statusCode ?: 0,
        statusMessage = this.statusMessage ?: " ",
        success = this.success
    )
}