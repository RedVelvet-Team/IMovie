package com.redvelvet.repository.repository

import com.redvelvet.entities.library.CreateList
import com.redvelvet.entities.library.StatusEntity
import com.redvelvet.repository.mapper.toCreateList
import com.redvelvet.repository.mapper.toStatusEntity
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class LibraryListRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : LibraryListsRepository, BaseRepository() {

    override suspend fun createList(
        sessionId: String,
        name: String,
        description: String?,
        language: String?
    ): CreateList {
        return remoteDataSource.createList(sessionId, name, description, language).toCreateList()
    }

    override suspend fun addMediaToList(listId: Int, mediaId: Int): StatusEntity {
        return remoteDataSource.addMediaToList(mediaId, listId).toStatusEntity()
    }

    override suspend fun deleteList(listId: Int): StatusEntity {
        TODO("Not yet implemented")
    }

}