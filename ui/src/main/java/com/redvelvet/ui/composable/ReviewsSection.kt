package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.screen.movieDetails.Item
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun ReviewsSection(
    isNotListEmpty: Boolean = false,
    items: List<Item> = emptyList(),
    onClickSeeAllReviews: (String) -> Unit = {},
    onClickReview: (id: String) -> Unit = {},
    itemId: String
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
                items = items,
                hasCustomList = true,
                hasDateAndCountry = false,
                customListItemComposable = { index ->
                    val item = items[index]
                    if (item.discription.isNotEmpty())
                        ItemReview(
                            id = item.strId,
                            name = item.name,
                            rating = item.stars,
                            date = item.date,
                            content = item.discription,
                            modifier = Modifier
                                .width(MaterialTheme.dimens.dimens270)
                                .height(MaterialTheme.dimens.dimens143),
                        )
                },
                onClickSeeAll = onClickSeeAllReviews,
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
                onClickItem = onClickReview,
                itemId = itemId
            )
        }

}