package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.composable.ItemsSectionForDetialsScreens
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun SimilarMoviesSection(
    it: List<MovieDetailsScreenUiState.MovieSimilarUiState>,
    interaction: MovieDetailsInteraction,
) {
    Column(
        modifier = Modifier
            .padding(
                bottom = MaterialTheme.spacing.spacing24,
            )
    ) {
        ItemsSectionForDetialsScreens(
            label = "Similar Movies",
            images = it.map { it2 -> it2.mediaImage },
            movieIds = it.map { it2 -> it2.mediaId },
            hasName = true,
            name = it.map { it2 -> it2.mediaName },
            hasCustomList = false,
            hasDateAndCountry = false,
            onClickSeeAll = { interaction.onClickSimilarMoviesSeeAll() },
            cardModifier = Modifier
                .width(MaterialTheme.dimens.dimens104)
                .height(MaterialTheme.dimens.dimens130),
        )
    }
}