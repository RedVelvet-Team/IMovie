package com.redvelvet.viewmodel.base

import com.redvelvet.entities.error.ErrorType

sealed class ErrorUiState{
    object NullData: ErrorUiState()
    object Network: ErrorUiState()
    object Server : ErrorUiState()
    object UnAuthorized : ErrorUiState()
    object InvalidUsernameOrPassword : ErrorUiState()
    object EmailNotVerified : ErrorUiState()
    object InvalidInput : ErrorUiState()
}

fun ErrorType.toErrorUiState(): ErrorUiState{
    return when(this){
        ErrorType.EmailNotVerified -> ErrorUiState.EmailNotVerified
        ErrorType.InvalidInput -> ErrorUiState.InvalidInput
        ErrorType.InvalidUsernameOrPassword -> ErrorUiState.InvalidUsernameOrPassword
        ErrorType.Network -> ErrorUiState.Network
        ErrorType.NullData -> ErrorUiState.NullData
        ErrorType.Server -> ErrorUiState.Server
        ErrorType.UnAuthorized -> ErrorUiState.UnAuthorized
    }
}
