package com.redvelvet.repository.repository

import com.redvelvet.repository.mapper.toErrorType
import com.redvelvet.repository.util.RemoteError

open class BaseRepository {
    protected suspend fun <T> wrapRemoteResponse(response: suspend () -> T): T {
        return try {
            response()
        } catch (e: RemoteError) {
            throw e.toErrorType()
        }
    }
}