package com.redvelvet.viewmodel.base

import com.redvelvet.entities.error.ErrorType

sealed class ErrorUiState(val message: String) {
    data object NullData : ErrorUiState("NullData")
    data object Network : ErrorUiState("Network")
    data object Server : ErrorUiState("Server")
    data object UnAuthorized : ErrorUiState("UnAuthorized")
    data object InvalidUsernameOrPassword : ErrorUiState("InvalidUsernameOrPassword")
    data object EmailNotVerified : ErrorUiState("EmailNotVerified")
    data object InvalidInput : ErrorUiState("InvalidInput")
    data object BadRequest : ErrorUiState("BadRequest")
}

fun ErrorType.toErrorUiState(): ErrorUiState {
    return when (this) {
        ErrorType.EmailNotVerified -> ErrorUiState.EmailNotVerified
        ErrorType.InvalidInput -> ErrorUiState.InvalidInput
        ErrorType.InvalidUsernameOrPassword -> ErrorUiState.InvalidUsernameOrPassword
        ErrorType.Network -> ErrorUiState.Network
        ErrorType.NullData -> ErrorUiState.NullData
        ErrorType.Server -> ErrorUiState.Server
        ErrorType.UnAuthorized -> ErrorUiState.UnAuthorized
        ErrorType.BadRequest -> ErrorUiState.BadRequest
    }
}
