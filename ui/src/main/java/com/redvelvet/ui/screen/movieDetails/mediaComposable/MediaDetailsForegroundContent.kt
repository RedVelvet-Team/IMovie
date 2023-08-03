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
            Column(
                modifier = Modifier
                    .padding(start = MaterialTheme.spacing.spacing16)
            ) {
                MediaInfoCard(
                    data = MediaInfoCardData(
                        it.posterPath,
                        it.originalTitle,
                        it.genres,
                        hasTime = true,
                        hasDate = false,
                        it.runtime,
                        it.spokenLanguages,
                    ),
                    onGenreClick = { uiEvent.onMovieCategory("") }
                )
                SpacerVertical(height = MaterialTheme.spacing.spacing24)
                MediaRateRow(it.voteAverage.toString(), { uiEvent.onRateMedia(5.5) })
                SpacerVertical(height = MaterialTheme.spacing.spacing24)
                Box(
                    modifier = Modifier
                        .padding(end = MaterialTheme.spacing.spacing16)
                ) {
                    LongExpandedText(it.overview)
                }
            }
        }
        SpacerVertical(height = MaterialTheme.spacing.spacing24)
        state.data?.topCast?.let {
            ItemsSection(
                label = "Top Cast",
                images = it.map { it2 -> it2.castImage },
                hasName = true,
                name = it.map { it2 -> it2.castName },
                hasCustomList = true,
                customListItemComposable = { index, image ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clickable { uiEvent.onCast(it[index].castId) }
                    ) {
                        CircularImageAvatar(imageUrl = image)
                        SpacerVertical(height = MaterialTheme.spacing.spacing4)
                        Box(
                            modifier = Modifier
                                .width(70.dp)
                        ) {
                            Text(
                                text = it[index].castName,
                                style = MaterialTheme.typography.bodySmall,
                                color = OnSecondary,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                },
            )
        }
    }

}

