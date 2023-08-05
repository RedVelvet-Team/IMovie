package com.redvelvet.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    val brand100: Color = Purple100,
    val brand80: Color = Purple80,
    val brand60: Color = Purple60,
    val brand40: Color = Purple40,
    val brand20: Color = Purple20,
    val brand10: Color = Purple10,
    val backgroundPrimary: Color = BackgroundPrimary,
    val backgroundOnPrimary: Color = BackgroundOnPrimary,
    val backgroundSecondary: Color = BackgroundSecondary,
    val backgroundOnSecondary: Color = BackgroundOnSecondary,
    val fontPrimary: Color = FontPrimary,
    val fontSecondary: Color = FontSecondary,
    val fontAccent: Color = FontAccent
)

val LocalColors = compositionLocalOf { Colors() }

val MaterialTheme.color: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
