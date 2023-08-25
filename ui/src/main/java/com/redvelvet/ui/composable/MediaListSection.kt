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
fun MediaListSection(
    label: String = "",
    isNotListEmpty: Boolean = false,
    items: List<Item> = emptyList(),
    onClickSeeAll: (String) -> Unit = {},
    onClickItem: (String) -> Unit = {},
    mediaId: Int,
) {
    if (isNotListEmpty)
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                )
        ) {
            ItemsSectionForDetailsScreens(
                label = label,
                items = items,
                hasName = true,
                hasCustomList = false,
                hasDateAndCountry = false,
                onClickSeeAll = { onClickSeeAll(mediaId.toString()) },
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
                onClickItem = onClickItem,
                itemId = mediaId.toString()
            )
        }
}
