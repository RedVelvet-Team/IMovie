package com.redvelvet.entities.error

sealed class ErrorType : Exception() {
    data object NullData : ErrorType()
    data object Network : ErrorType()
    data object Server : ErrorType()
    data object UnAuthorized : ErrorType()
    data object InvalidUsernameOrPassword : ErrorType()
    data object EmailNotVerified : ErrorType()
    data object InvalidInput : ErrorType()
}