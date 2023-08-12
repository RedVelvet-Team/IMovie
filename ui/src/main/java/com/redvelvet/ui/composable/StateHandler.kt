package com.redvelvet.ui.composable

import androidx.compose.runtime.Composable

@Composable
fun StateHandler(
    onLoading: @Composable () -> Unit,
    onFailure: @Composable () -> Unit,
    onSuccess: @Composable () -> Unit,
    isLoading: Boolean,
    isError: Boolean,
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