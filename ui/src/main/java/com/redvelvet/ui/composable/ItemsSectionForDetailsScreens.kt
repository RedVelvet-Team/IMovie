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
import com.redvelvet.ui.screen.movieDetails.Item
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.utils.SeeAllMovie

@Composable
fun ItemsSectionForDetailsScreens(
    label: String = "",
    items: List<Item> = emptyList(),
    hasName: Boolean = false,
    hasCustomList: Boolean = false,
    customListItemComposable: @Composable ((index: Int) -> Unit)? = null,
    onClickSeeAll: (String) -> Unit = {},
    cardModifier: Modifier? = null,
    headerModifier: Modifier = Modifier,
    hasDateAndCountry: Boolean = false,
    onClickItem: (String) -> Unit = {},
    itemId: String
) {
    SectionHeader(
        label = label,
        modifier = headerModifier,
        seeAllMovie = SeeAllMovie.POPULAR,
        onClickSeeAll = { onClickSeeAll(itemId) }
    )
    LazyRow(
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        if (hasCustomList && (label == "Reviews" || label == "Seasons")) {
            items(items.size) {
                customListItemComposable!!(it)
            }
        }
        items(items.size) {
            val item = items[it]
            if (hasCustomList) {
                customListItemComposable!!(it)
            }
            if (!hasCustomList) {
                ItemBasicCardForDetailsScreens(
                    imagePainter = rememberAsyncImagePainter(
                        model = item.image
                    ),
                    modifier = cardModifier ?: Modifier
                        .width(MaterialTheme.dimens.dimens104)
                        .height(MaterialTheme.dimens.dimens130),
                    hasName = hasName,
                    name = if (hasName) item.name else "",
                    id = if (items.isNotEmpty()) item.id else 9999,
                    hasDateAndCountry = hasDateAndCountry,
                    date = if (hasDateAndCountry) item.date else "",
                    country = if (hasDateAndCountry) item.country else "",
                    onClick = onClickItem,
                )
            }
        }
    }
}