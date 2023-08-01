package com.redvelvet.repository.repository

import com.redvelvet.repository.mapper.toErrorType
import com.redvelvet.repository.util.RemoteError

open class BaseRepository {
    protected fun <T> wrapRemoteResponse(response: suspend () -> T): suspend () -> T {
        try {
            return response
        } catch (e: RemoteError) {
            throw e.toErrorType()
        }
    }
}