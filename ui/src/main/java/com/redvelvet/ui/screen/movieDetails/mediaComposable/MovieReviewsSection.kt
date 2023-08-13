package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.ItemReview
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun MovieReviewsSection(
    it: List<MovieDetailsScreenUiState.MovieReviewsUiState>,
    interaction: MovieDetailsInteraction
) {
    ItemsSection<Any>(
        label = "Reviews",
        hasName = false,
        name = it.map { it2 -> it2.reviewAuthor },
        hasCustomList = true,
        hasDateAndCountry = false,
        customListItemComposable = { index, _ ->
            if (it[index].reviewDescription.isNotEmpty())
                ItemReview(
                    name = it[index].reviewAuthor,
                    rating = it[index].reviewStars,
                    date = it[index].reviewDate,
                    content = it[index].reviewDescription,
                    modifier = Modifier
                        .width(MaterialTheme.dimens.dimens270)
                        .height(MaterialTheme.dimens.dimens143),
                )
        },
        onClickSeeAll = { interaction.onClickTopCastSeeAll() },
        cardModifier = Modifier
            .width(MaterialTheme.dimens.dimens104)
            .height(MaterialTheme.dimens.dimens130),

        )

}

