package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun WallPaper(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Background image onBoarding",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )
}