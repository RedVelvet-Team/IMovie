package com.redvelvet.ui.screen.movieDetails.mediaComposable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
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

    }
}

@Composable
fun MovieImagesSection(
    it: List<MovieDetailsScreenUiState.MovieImagesUiState>,
    interaction: MovieDetailsInteraction
) {
    ItemsSection(
        label = "Images belong a movie",
        images = it.map { it2 -> it2.mediaImage },
        hasName = false,
        hasCustomList = false,
        hasDateAndCountry = false,
        onClickSeeAll = { interaction.onClickMovieImagesSeeAll() },
        cardModifier = Modifier
            .width(MaterialTheme.dimens.dimens112)
            .height(MaterialTheme.dimens.dimens112),
    )
}

