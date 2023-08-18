package com.redvelvet.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R

@Composable
fun rememberAsyncFlixImage(
    image: String,
    placeholderImage: Painter = painterResource(id = R.drawable.login),
    errorImage: Painter = painterResource(id = R.drawable.image_placeholder),
): AsyncImagePainter {
    return rememberAsyncImagePainter(
        model = image,
        placeholder = placeholderImage,
        error = errorImage
    )
}