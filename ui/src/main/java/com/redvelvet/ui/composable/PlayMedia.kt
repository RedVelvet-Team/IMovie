package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun PlayMedia(icon: Int, description: Int, onMediaPlay: () -> Unit, modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = stringResource(id = description),
        modifier = modifier
            .clickable {
                onMediaPlay()
            }
    )
}