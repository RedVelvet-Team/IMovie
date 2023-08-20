package com.redvelvet.ui.composable

import androidx.compose.runtime.Composable

@Composable
fun StateHandler(
    isLoading: Boolean,
    isError: Boolean,
    isEmpty: Boolean = false,
    onLoading: @Composable () -> Unit = { LoadingState() },
    onFailure: @Composable () -> Unit = { ErrorState() },
    onSuccess: @Composable () -> Unit,
    onEmpty: @Composable () -> Unit,
) {
    when {
        isLoading -> onLoading()
        isError -> onFailure()
        isEmpty -> onEmpty()
        else -> onSuccess()
    }
}