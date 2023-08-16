package com.redvelvet.ui.screen.movieDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.composable.ItemReview
import com.redvelvet.ui.composable.ItemsSectionForDetailsScreens
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun MovieReviewsSection(
    it: List<MovieDetailsScreenUiState.MovieReviewsUiState>,
    interaction: MovieDetailsInteraction
) {
    if (it.isNotEmpty())
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                )
        ) {
            ItemsSectionForDetailsScreens(
                label = "Reviews",
                hasName = false,
                name = it.map { it2 -> it2.reviewAuthor },
                hasCustomList = true,
                hasDateAndCountry = false,
                customListItemComposable = { index ->
                    if (it[index].reviewDescription.isNotEmpty())
                        ItemReview(
                            id = it[index].reviewId,
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

}

