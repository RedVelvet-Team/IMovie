package com.redvelvet.entities

sealed class ErrorType: Exception() {
    object NullData: ErrorType()
    object Network: ErrorType()
    object Server: ErrorType()
    object UnAuthorized: ErrorType()
    object InvalidUsernameOrPassword: ErrorType()
    object EmailNotVerified: ErrorType()
    object InvalidInput: ErrorType()
}