package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.screen.movieDetails.MovieDetailsScreen
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
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
    interaction: MovieDetailsInteraction,
    onScroll: (offset: Int) -> Unit
) {
    val scrollState = rememberScrollState()
    LaunchedEffect(scrollState.value) {
        onScroll(scrollState.value)
    }
    Column(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxSize()
            .zIndex(1f)
            .verticalScroll(scrollState)
    ) {
        val roundedCorners = if (scrollState.value > 790) 0.dp else MaterialTheme.radius.radius32
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.spacing285)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = roundedCorners,
                        topEnd = roundedCorners,
                    )
                )
                .fillMaxSize()
                .background(color = Primary)
                .padding(top = MaterialTheme.spacing.spacing24),
        ) {
            state.data?.details?.let {
                MovieDetailsInfoSection(it, interaction)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))
            state.data?.topCast?.let {
                TopCastSection(it, interaction)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))
            state.data?.details?.let {
                MovieDetailsMoreInfoSection(it)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))
            state.data?.keyWords?.let {
                KeyWordsSection(it, interaction)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))
            state.data?.similar?.let {
                SimilarMoviesSection(it, interaction)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))
            state.data?.images?.let {
                MovieImagesSection(it, interaction)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))
            state.data?.reviews?.let {
                MovieReviewsSection(it, interaction)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))
            state.data?.recommendations?.let {
                RecommendedMoviesSection(it, interaction)
            }
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.spacing24))

        }
    }
}

@Composable
fun RecommendedMoviesSection(
    it: List<MovieDetailsScreenUiState.MovieRecommendationsUiState>,
    interaction: MovieDetailsInteraction
) {
    ItemsSection(
        label = "Recommendations",
        images = it.map { it2 -> it2.mediaImage },
        movieIds = it.map { it2 -> it2.mediaId },
        hasName = true,
        name = it.map { it2 -> it2.mediaName },
        hasCustomList = false,
        hasDateAndCountry = false,
        onClickSeeAll = { interaction.onClickRecommendationsMoviesSeeAll() },
        cardModifier = Modifier
            .width(MaterialTheme.dimens.dimens104)
            .height(MaterialTheme.dimens.dimens130),
    )
}

