package com.redvelvet.viewmodel.base

open class ErrorUiState(message: String?)
class NullResultErrorState(message: String?): ErrorUiState(message)
class InvalidationErrorState(message: String?): ErrorUiState(message)
class NetworkErrorState(message: String?): ErrorUiState(message)

