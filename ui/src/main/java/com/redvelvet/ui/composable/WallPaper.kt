package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.redvelvet.ui.R

@Composable
fun WallPaper(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = stringResource(R.string.background_image_onboarding),
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}