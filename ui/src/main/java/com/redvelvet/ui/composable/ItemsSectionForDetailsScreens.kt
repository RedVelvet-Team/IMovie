package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun ItemsSectionForDetailsScreens(
    label: String = "",
    images: List<String> = emptyList(),
    hasName: Boolean = false,
    name: List<String> = emptyList(),
    hasCustomList: Boolean = false,
    customListItemComposable: @Composable ((index: Int) -> Unit)? = null,
    onClickSeeAll: () -> Unit = {},
    cardModifier: Modifier? = null,
    headerModifier: Modifier = Modifier,
    hasDateAndCountry: Boolean = false,
    date: List<String> = emptyList(),
    country: List<String> = emptyList(),
    onClickItem: (id: Int) -> Unit = {},
) {
    SectionHeader(label, modifier = headerModifier, onClickSeeAll = onClickSeeAll)
    LazyRow(
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        if (hasCustomList && label == "Reviews") {
            items(name.size) {
                customListItemComposable!!(it)
            }
        }
        items(images.size) {
            if (hasCustomList) {
                customListItemComposable!!(it)
            }
            if (!hasCustomList) {
                ItemBasicCardForDetailsScreens(
                    imagePainter = rememberAsyncImagePainter(
                        model = images[it]
                    ),
                    modifier = cardModifier ?: Modifier
                        .width(MaterialTheme.dimens.dimens104)
                        .height(MaterialTheme.dimens.dimens130),
                    hasName = hasName,
                    name = if (hasName) name[it] else "",
                    hasDateAndCountry = hasDateAndCountry,
                    date = if (hasDateAndCountry) date[it] else "",
                    country = if (hasDateAndCountry) country[it] else "",
                    onClick = onClickItem,
                )
            }
        }
    }
}
