package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun ReviewsSection(
    isNotListEmpty: Boolean = false,
    reviewNames: List<String> = emptyList(),
    reviewIds: List<String> = emptyList(),
    reviewStars: List<Double> = emptyList(),
    reviewDates: List<String> = emptyList(),
    reviewDescriptions: List<String> = emptyList(),
    onClickSeeAllReviews: () -> Unit = {},
    onClickReview: (id: Int) -> Unit = {},
) {
    if (isNotListEmpty)
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                )
        ) {
            ItemsSectionForDetailsScreens(
                label = "Reviews",
                hasName = false,
                name = reviewNames,
                hasCustomList = true,
                hasDateAndCountry = false,
                customListItemComposable = { index ->
                    if (reviewDescriptions[index].isNotEmpty())
                        ItemReview(
                            id = reviewIds[index],
                            name = reviewNames[index],
                            rating = reviewStars[index],
                            date = reviewDates[index],
                            content = reviewDescriptions[index],
                            modifier = Modifier
                                .width(MaterialTheme.dimens.dimens270)
                                .height(MaterialTheme.dimens.dimens143),
                        )
                },
                onClickSeeAll = { onClickSeeAllReviews },
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
                onClickItem = onClickReview
            )
        }

}