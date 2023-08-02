package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.CustomButton
import com.redvelvet.ui.composable.GenreButton
import com.redvelvet.ui.screen.movieDetails.MovieDetailsUiEvent
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.LabeledValueHorizontal
import com.redvelvet.ui.composable.SpacerHorizontal
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.screen.movieDetails.MovieDetailsScreen
import com.redvelvet.ui.screen.movieDetails.MovieEventsTest
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Typography
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
    state.data?.details?.let {
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
            Column(
                modifier = Modifier
                    .padding(start = MaterialTheme.spacing.spacing16)
            ) {
                MediaInfoCard(it)
            }
        }
    }
}

@Composable
fun MediaInfoCard(movieDetails: MovieDetailsScreenUiState.MovieDetailsUiState) {
    Row {
        ItemBasicCard(
            image = movieDetails.posterPath,
            hasName = false,
            name = movieDetails.originalTitle,
            hasDateAndCountry = false,
        )
        SpacerHorizontal(width = MaterialTheme.spacing.spacing12)
        Column {
            Text(
                text = movieDetails.originalTitle,
                style = Typography.headlineMedium,
                color = Color.White
            )
            SpacerVertical(height = MaterialTheme.spacing.spacing16)
            LazyRow {
                items(movieDetails.genres.size) {
                    GenreButton(genre = movieDetails.genres[it])
                }
            }
            SpacerVertical(height = MaterialTheme.spacing.spacing12)
            LabeledValueHorizontal(
                movieTime = movieDetails.runtime,
                icon = R.drawable.movie_time,
                iconDescription = R.string.movie_time
            )
            SpacerVertical(height = MaterialTheme.spacing.spacing8)
            LabeledValueHorizontal(
                movieTime = movieDetails.releaseDate,
                icon = R.drawable.global,
                iconDescription = R.string.movie_language
            )
        }

    }
}