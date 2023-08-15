package com.redvelvet.ui.composable

import androidx.compose.runtime.Composable

@Composable
fun StateHandler(
    isLoading: Boolean,
    isError: Boolean,
    onLoading: @Composable () -> Unit = { LoadingState() },
    onFailure: @Composable () -> Unit = { ErrorState() },
    onSuccess: @Composable () -> Unit,
) {
    when {
        isLoading -> {
            onLoading()
        }

        !isError -> {
            onSuccess()
        }

        else -> {
            onFailure()
        }
    }
}