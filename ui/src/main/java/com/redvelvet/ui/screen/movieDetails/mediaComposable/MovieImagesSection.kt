package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

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
