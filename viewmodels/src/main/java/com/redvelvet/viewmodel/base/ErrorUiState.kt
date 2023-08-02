package com.redvelvet.viewmodel.base

import com.redvelvet.entities.error.ErrorType

sealed class ErrorUiState {
    data object NullData : ErrorUiState()
    data object Network : ErrorUiState()
    data object Server : ErrorUiState()
    data object UnAuthorized : ErrorUiState()
    data object InvalidUsernameOrPassword : ErrorUiState()
    data object EmailNotVerified : ErrorUiState()
    data object InvalidInput : ErrorUiState()
    data object BadRequest : ErrorUiState()
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
