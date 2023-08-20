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
fun TopCastSection(
    isNotListEmpty: Boolean = false,
    onClickSeeAll: () -> Unit = {},
    onClickItem: (id: Int) -> Unit = {},
    castIds: List<Int> = emptyList(),
    images: List<String> = emptyList(),
    names: List<String> = emptyList(),
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
                images = images,
                hasName = true,
                name = names,
                hasCustomList = true,
                customListItemComposable = { index ->
                    TopCast(castId = castIds[index], names[index], onClickItem, images[index])
                },
                onClickSeeAll = onClickSeeAll,
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
            )
        }
}

