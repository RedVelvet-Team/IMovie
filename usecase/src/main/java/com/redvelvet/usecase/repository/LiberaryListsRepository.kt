package com.redvelvet.usecase.repository

import com.redvelvet.entities.library.CreateList

interface LiberaryListsRepository {

    suspend fun createList(
        sessionId: String,
        name: String,
        description: String?,
        language: String?
    ): CreateList

}