package com.redvelvet.repository.repository

open class BaseRepository {
    protected suspend fun <T> wrapRemoteResponse(response: suspend () -> T): T {
        return response()
    }
}