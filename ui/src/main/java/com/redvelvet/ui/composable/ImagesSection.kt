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
fun ImagesSection(
    it: List<String> = emptyList(),
    onClickSeeAll: () -> Unit = {},
) {
    if (it.isNotEmpty())
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                )
        ) {
            ItemsSectionForDetailsScreens(
                label = "Images belong a movie",
                images = it,
                hasName = false,
                hasCustomList = false,
                hasDateAndCountry = false,
                onClickSeeAll = { onClickSeeAll },
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens112)
                    .height(MaterialTheme.dimens.dimens112),
            )
        }
}

