package com.redvelvet.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale

@Composable
fun BackgroundMediaImage(
    image: String,
    placeholder: Int,
    contentDescription: Int,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current).data(image)
            .crossfade(true).scale(Scale.FIT).build(),
        placeholder = painterResource(placeholder),
        contentDescription = stringResource(contentDescription),
    )
}
