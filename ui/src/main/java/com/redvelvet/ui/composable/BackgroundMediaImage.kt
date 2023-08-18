package com.redvelvet.ui.composable

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale

@Composable
fun BackgroundMediaImage(
    image: String,
    placeholder: Int,
    error: Int,
    contentDescription: Int,
    modifier: Modifier = Modifier,
    scale: Scale = Scale.FILL,
) {
    AnimatedVisibility(
        LocalConfiguration.current.orientation == Configuration.ORIENTATION_PORTRAIT
    ) {
        AsyncImage(
            modifier = modifier
                .shadow(4.dp, ambientColor = Color(0x51000000))
                .graphicsLayer(alpha = 0.32f),
            model = ImageRequest.Builder(LocalContext.current).data(image)
                .crossfade(true).scale(scale).build(),
            placeholder = painterResource(placeholder),
            contentDescription = stringResource(contentDescription),
            error = painterResource(id = error),
        )
    }
    AnimatedVisibility(
        LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE
    ) {
        AsyncImage(
            modifier = modifier
                .shadow(4.dp, ambientColor = Color(0x51000000))
                .graphicsLayer(alpha = 0.32f),
            model = ImageRequest.Builder(LocalContext.current).data(image)
                .crossfade(true).scale(scale).build(),
            placeholder = painterResource(placeholder),
            contentDescription = stringResource(contentDescription),
            error = painterResource(id = error),
            contentScale = ContentScale.FillBounds
        )
    }
}

