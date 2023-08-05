package com.redvelvet.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimens(
    val dimens1: Dp = 1.dp,
    val dimens8: Dp = 8.dp,
    val dimens4: Dp = 8.dp,
    val dimens16: Dp = 16.dp,
    val dimens24: Dp = 24.dp,
    val dimens32: Dp = 32.dp,
    val dimens36: Dp = 36.dp,
    val dimens49: Dp = 49.dp,
    val dimens78: Dp = 78.dp,
    val dimens100: Dp = 100.dp,
    val dimens56: Dp = 56.dp,
    val dimens70: Dp = 70.dp,
    val dimens104: Dp = 104.dp,
    val dimens130: Dp = 130.dp,
    val dimens193: Dp = 193.dp,
    val dimens365: Dp = 365.dp,


)

val LocalDimens = compositionLocalOf { Dimens() }

val MaterialTheme.dimens: Dimens
    @Composable
    @ReadOnlyComposable
    get() = LocalDimens.current