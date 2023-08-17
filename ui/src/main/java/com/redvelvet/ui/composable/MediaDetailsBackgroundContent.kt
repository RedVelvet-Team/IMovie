package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.size.Scale
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.spacing

@Composable
fun MediaDetailsBackgroundContent(
    mediaImage: String,
    onPlayTrailer: (video: String) -> Unit = {},
    trailerVideoUrl: String
) {
    Box {
        BackgroundMediaImage(
            image = mediaImage,
            placeholder = R.drawable.ic_launcher_background,
            contentDescription = R.string.movies_details_background_image,
            modifier = Modifier.fillMaxWidth()
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = { onPlayTrailer(trailerVideoUrl) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
    }
}

