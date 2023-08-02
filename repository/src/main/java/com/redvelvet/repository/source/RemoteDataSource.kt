package com.redvelvet.repository.source

import com.redvelvet.repository.dto.search.BaseSearchDto

interface RemoteDataSource {

    suspend fun multiSearch(query: String, page : Int?): BaseSearchDto
}