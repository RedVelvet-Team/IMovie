package com.redvelvet.repository

import com.redvelvet.entities.error.ErrorType

fun RemoteError.toErrorType(): ErrorType {
    return when(this){
        is RemoteError.Network -> ErrorType.Network
        is RemoteError.NullData -> ErrorType.NullData
        is RemoteError.InvalidUsernamePassword -> ErrorType.InvalidUsernameOrPassword
        is RemoteError.EmailNotVerified -> ErrorType.EmailNotVerified
        is RemoteError.InvalidInput -> ErrorType.InvalidInput
        is RemoteError.AuthenticationFailed -> ErrorType.UnAuthorized
        is RemoteError.AuthenticationFailed2 -> ErrorType.UnAuthorized
        else -> ErrorType.Server
    }
}