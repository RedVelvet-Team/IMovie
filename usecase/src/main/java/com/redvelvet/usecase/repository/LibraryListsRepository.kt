package com.redvelvet.usecase.repository

import com.redvelvet.entities.library.CreateList
import com.redvelvet.entities.library.StatusEntity

interface LibraryListsRepository {

    suspend fun createList(
        name: String,
    ): CreateList

    suspend fun addMediaToList(
        listId: Int,
        mediaId: Int
    ): StatusEntity

    suspend fun removeMediaFromList(
        listId: Int,
        mediaId: Int
    ): StatusEntity

    suspend fun deleteList(
        listId: Int
    ): StatusEntity

    suspend fun clearList(
        listId: Int
    ): StatusEntity
}