package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.BackgroundMediaImage
import com.redvelvet.ui.composable.PlayMedia
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction

@Composable
fun TvShowDetailsBackgroundContent(
    mediaImage: String,
    interaction: TvShowDetailsInteraction,
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
            onMediaPlay = { interaction.onClickPlayTrailer(trailerVideoUrl) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
    }
}