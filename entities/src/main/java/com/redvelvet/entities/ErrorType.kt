package com.redvelvet.entities

sealed class ErrorType: Exception() {
    data object Error: ErrorType()
}