package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.BackgroundMediaImage
import com.redvelvet.ui.composable.PlayMedia
import com.redvelvet.ui.screen.movieDetails.MovieDetailsScreen
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewMovieDetailsScreen() {
    MovieDetailsScreen(rememberNavController())
}

@Composable
fun MediaDetailsBackgroundContent(
    mediaImage: String,
    interaction: MovieDetailsInteraction,
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