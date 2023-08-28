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
        name: String,
    ): CreateList {
        return remoteDataSource.createList(name).toCreateList()
    }

    override suspend fun addMediaToList(listId: Int, mediaId: Int): StatusEntity {
        return remoteDataSource.addMediaToList(mediaId, listId).toStatusEntity()
    }

    override suspend fun removeMediaFromList(listId: Int, mediaId: Int): StatusEntity {
        return remoteDataSource.deleteMediaFromList(mediaId, listId).toStatusEntity()
    }

    override suspend fun deleteList(listId: Int): StatusEntity {
        return remoteDataSource.deleteList(listId).toStatusEntity()
    }

    override suspend fun clearList(listId: Int): StatusEntity {
        return remoteDataSource.clearList(listId).toStatusEntity()
    }

}