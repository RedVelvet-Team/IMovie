package com.redvelvet.repository.pagingSource

import com.redvelvet.entities.people.People
import com.redvelvet.repository.mapper.toPeopleEntity
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class PeopleSearchPageSource  @Inject constructor(
    remoteDataSource: RemoteDataSource,
    private val query: String
) : BasePagingSource<People>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<People> {
        return remoteDataSource.searchPeople(query = query, page = page).map { it.toPeopleEntity() }
    }
}