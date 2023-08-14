package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun TopCastSection(
    it: List<MovieDetailsScreenUiState.MovieTopCastUiState>,
    interaction: MovieDetailsInteraction,
) {
    Column(
        modifier = Modifier
            .padding(
                bottom = MaterialTheme.spacing.spacing24,
            )
    ) {
        ItemsSection(
            label = "Top Cast",
            images = it.map { it2 -> it2.castImage },
            hasName = true,
            name = it.map { it2 -> it2.castName },
            hasCustomList = true,
            customListItemComposable = { index, image ->
                TopCast(it, index, image, interaction)
            },
            onClickSeeAll = { interaction.onClickTopCastSeeAll() },
            cardModifier = Modifier
                .width(MaterialTheme.dimens.dimens104)
                .height(MaterialTheme.dimens.dimens130),
        )
    }
}

