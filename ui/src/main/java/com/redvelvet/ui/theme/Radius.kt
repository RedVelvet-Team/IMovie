package com.redvelvet.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Radius(
    val radius8: Dp = 8.dp,
    val radius10: Dp = 10.dp,
    val radius16: Dp = 16.dp,
    val radius20: Dp = 20.dp,
    val radius24: Dp = 24.dp,
    val radius50: Dp = 50.dp
)

val LocalRadius = compositionLocalOf { Radius() }

val MaterialTheme.radius: Radius
    @Composable
    @ReadOnlyComposable
    get() = LocalRadius.current