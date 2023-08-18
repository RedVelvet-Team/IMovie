package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R

@Composable
fun rememberAsyncFlixImage(
    image: String,
    modifier: Modifier = Modifier,
    placeholderImage: Painter = painterResource(id = R.drawable.image_placeholder),
    errorImage: Painter = painterResource(id = R.drawable.image_placeholder),
) {
    Image(
        painter = rememberAsyncImagePainter(
            model = image,
            placeholder = placeholderImage,
            error = errorImage
        ),
        modifier = modifier,
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )
}