package com.redvelvet.usecase.repository

import com.redvelvet.entities.library.StatusEntity
import com.redvelvet.entities.library.list.CreateListResponse

interface LibraryListsRepository {

    suspend fun createList(
        name: String,
    ): CreateListResponse

    suspend fun addMediaToList(
        listId: Int,
        mediaId: Int
    ): StatusEntity

    suspend fun removeMediaFromList(
        listId: Int, mediaId: Int, sessionId: String
    ): StatusEntity

    suspend fun deleteList(
        listId: Int, sessionId: String
    ): StatusEntity

    suspend fun clearList(
        listId: Int
    ): StatusEntity
}