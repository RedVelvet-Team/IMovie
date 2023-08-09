package com.redvelvet.repository.pagingSource

import com.redvelvet.entities.actor.Actor
import com.redvelvet.repository.mapper.toActor
import com.redvelvet.repository.source.RemoteDataSource
import javax.inject.Inject

class ActorSearchPageSource  @Inject constructor(
    remoteDataSource: RemoteDataSource,
    private val query: String
) : BasePagingSource<Actor>(remoteDataSource) {
    override suspend fun fetchData(page: Int): List<Actor> {
        return remoteDataSource.searchPeople(query = query, page = page).map { it.toActor() }
    }
}