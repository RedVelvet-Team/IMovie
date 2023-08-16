package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

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
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction
import com.redvelvet.viewmodel.tvshow.TvShowReviewUiState

@Composable
fun TvShowReviewsSection(
    it: List<TvShowReviewUiState>,
    interaction: TvShowDetailsInteraction
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
                name = it.map { it2 -> it2.author },
                hasCustomList = true,
                hasDateAndCountry = false,
                customListItemComposable = { index ->
                    if (it[index].content.isNotEmpty())
                        ItemReview(
                            id = it[index].id,
                            name = it[index].author,
                            rating = it[index].rating.toDouble(),
                            date = it[index].createdAt,
                            content = it[index].content,
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

