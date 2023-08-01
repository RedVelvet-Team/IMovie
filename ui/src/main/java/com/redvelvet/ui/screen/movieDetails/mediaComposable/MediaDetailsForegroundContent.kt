package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.PlayMedia
import com.redvelvet.ui.screen.movieDetails.MovieDetailsScreen
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState


@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewMovieDetailsScreen1() {
    MovieDetailsScreen(rememberNavController())
}

@Composable
fun MediaDetailsForegroundContent(
    state: MovieDetailsScreenUiState,
    onMediaCategory: () -> Unit,
    onDescriptionMore: () -> Unit,
    onTopCastSeeAll: () -> Unit,
    onCast: () -> Unit,
    onMediaKeyword: () -> Unit,
    onSimilarMovieSeeAll: () -> Unit,
    onRecommendedMediaSeeAll: () -> Unit,
    onMedia: () -> Unit,
    onMediaImagesSeeAll: () -> Unit,
    onMediaImage: () -> Unit,
    onMediaReviewsSeeAll: () -> Unit,
    onMediaReview: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = MaterialTheme.spacing.spacing285)
            .clip(
                shape = RoundedCornerShape(
                    topStart = MaterialTheme.radius.radius32,
                    topEnd = MaterialTheme.radius.radius32
                )
            )
            .fillMaxSize()
            .background(color = Primary)
            .padding(top = MaterialTheme.spacing.spacing24)
    ) {
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
        PlayMedia(
            icon = R.drawable.play_media,
            description = R.string.movies_details_play,
            onMediaPlay = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = MaterialTheme.spacing.spacing127
                )
        )
    }
}
