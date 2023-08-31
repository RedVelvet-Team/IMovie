package com.redvelvet.repository.repository

import com.redvelvet.entities.library.StatusEntity
import com.redvelvet.entities.library.list.CreateListResponse
import com.redvelvet.entities.library.list.CreatedLists
import com.redvelvet.repository.mapper.toCreateList
import com.redvelvet.repository.mapper.toDomain
import com.redvelvet.repository.mapper.toStatusEntity
import com.redvelvet.repository.source.RemoteDataSource
import com.redvelvet.usecase.repository.LibraryListsRepository
import javax.inject.Inject

class LibraryListRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : LibraryListsRepository, BaseRepository() {

    override suspend fun createList(
        name: String,
        sessionId: String
    ): CreateListResponse {
        return remoteDataSource.createList(name, sessionId).toCreateList()
    }

    override suspend fun addMediaToList(listId: Int, mediaId: Int): StatusEntity {
        return remoteDataSource.addMediaToList(mediaId, listId).toStatusEntity()
    }

    override suspend fun removeMediaFromList(
        listId: Int,
        mediaId: Int,
        sessionId: String
    ): StatusEntity {
        return remoteDataSource.deleteMediaFromList(mediaId, listId, sessionId).toStatusEntity()
    }

    override suspend fun deleteList(listId: Int, sessionId: String): StatusEntity {
        return remoteDataSource.deleteList(listId, sessionId).toStatusEntity()
    }

    override suspend fun clearList(listId: Int): StatusEntity {
        return remoteDataSource.clearList(listId).toStatusEntity()
    }

    override suspend fun getLists(accountId: Int, sessionId: String): CreatedLists {
        return remoteDataSource.getCreatedLists(accountId, sessionId).toDomain()
    }
}