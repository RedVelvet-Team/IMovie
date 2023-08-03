package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.composable.CircularImageAvatar
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.composable.LongExpandedText
import com.redvelvet.ui.composable.MediaInfoCard
import com.redvelvet.ui.composable.MediaInfoCardData
import com.redvelvet.ui.composable.MediaRateRow
import com.redvelvet.ui.screen.movieDetails.MovieDetailsUiEvent
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.screen.movieDetails.MovieDetailsScreen
import com.redvelvet.ui.screen.movieDetails.MovieEventsTest
import com.redvelvet.ui.theme.OnSecondary
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
    val uiEvent: MovieDetailsUiEvent = MovieEventsTest()
    MovieDetailsScreen(rememberNavController(), uiEvent)

}

@Composable
fun MediaDetailsForegroundContent(
    state: MovieDetailsScreenUiState,
    uiEvent: MovieDetailsUiEvent,
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
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
            .padding(top = MaterialTheme.spacing.spacing24),
    ) {
        state.data?.details?.let {
            MovieDetailsInfoSection(it, uiEvent)
        }
        SpacerVertical(height = MaterialTheme.spacing.spacing24)
        state.data?.topCast?.let {
            TopCastSection(it, uiEvent)
        }
        SpacerVertical(height = MaterialTheme.spacing.spacing24)

    }

}


