package com.redvelvet.repository.repository

import com.redvelvet.entities.library.CreateList
import com.redvelvet.repository.mapper.toCreateList
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.LiberaryListsRepository
import javax.inject.Inject

class LiberaryListRepositoryImp  @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : LiberaryListsRepository, BaseRepository() {

    override suspend fun createList(
        sessionId: String,
        name: String,
        description: String?,
        language: String?
    ): CreateList {
        return remoteDataSource.createList(sessionId, name , description, language).toCreateList()
    }

}