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
fun TopCastSection(
    isNotListEmpty: Boolean = false,
    onClickSeeAll: (id: String) -> Unit = {},
    onClickItem: (id: Int) -> Unit = {},
    items: List<Item> = emptyList(),
    mediaId: String,
) {
    if (isNotListEmpty)
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                )
        ) {
            ItemsSectionForDetailsScreens(
                label = "Top Cast",
                items = items,
                hasName = true,
                hasCustomList = true,
                customListItemComposable = { index ->
                    TopCast(
                        castId = items[index].id,
                        items[index].name,
                        onClickItem,
                        items[index].image
                    )
                },
                onClickSeeAll = { onClickSeeAll(mediaId) },
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
                itemId = mediaId
            )
        }
}

