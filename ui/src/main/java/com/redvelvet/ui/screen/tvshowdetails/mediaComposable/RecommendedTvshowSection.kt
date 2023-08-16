package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.ItemsSectionForDetialsScreens
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction
import com.redvelvet.viewmodel.tvshow.TvShowRecommendationUiState

@Composable
fun RecommendedTvshowSection(
    it: List<TvShowRecommendationUiState>,
    interaction: TvShowDetailsInteraction
) {
    if (it.isNotEmpty())
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                )
        ) {
            ItemsSectionForDetialsScreens(
                label = "Recommendations",
                images = it.map { it2 -> it2.poster },
                movieIds = it.map { it2 -> it2.id },
                hasName = true,
                name = it.map { it2 -> it2.seriesName },
                hasCustomList = false,
                hasDateAndCountry = false,
                onClickSeeAll = { interaction.onClickRecommendationsSeriesSeeAll() },
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
            )
        }
}

