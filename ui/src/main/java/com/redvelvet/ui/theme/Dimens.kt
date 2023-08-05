package com.redvelvet.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val dimens0: Dp = 0.dp,
    val dimens8: Dp = 8.dp,
    val dimens16: Dp = 16.dp,
    val dimens24: Dp = 24.dp,
    val dimens32: Dp = 32.dp,
    val dimens36: Dp = 36.dp,
    val dimens193: Dp = 193.dp,
)

val LocalDimens = compositionLocalOf { Dimens() }

val MaterialTheme.dimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current