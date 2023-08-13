package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction

@Composable
fun <T> ItemsSection(
    label: String = "",
    images: List<T> = emptyList(),
    headerModifier: Modifier = Modifier,
    cardModifier: Modifier? = null,
    hasName: Boolean = false,
    name: List<String> = emptyList(),
    hasDateAndCountry: Boolean = false,
    date: List<String> = emptyList(),
    country: List<String> = emptyList(),
    hasCustomList: Boolean = false,
    customListItemComposable: @Composable ((index: Int, image: String) -> Unit)? = null,
    onClickSeeAll: () -> Unit = {},
    onClickItem: (id: Int) -> Unit = {},
    movieIds: List<Int> = emptyList(),
) {
    SectionHeader(label, modifier = headerModifier, onClickSeeAll = onClickSeeAll)
    LazyRow(
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        itemsIndexed(images) { index, image ->
            val imagePainter =
                if (image is Int) painterResource(image) else rememberAsyncImagePainter(
                    model = image
                )
            if (hasCustomList) {
                customListItemComposable!!(index, image as String)
            }
            if (!hasCustomList) {
                ItemBasicCard(
                    imagePainter = imagePainter,
                    modifier = cardModifier ?: Modifier
                        .width(MaterialTheme.dimens.dimens104)
                        .height(MaterialTheme.dimens.dimens130),
                    hasName = hasName,
                    name = if (hasName) name[index] else "",
                    hasDateAndCountry = hasDateAndCountry,
                    date = if (hasDateAndCountry) date[index] else "",
                    country = if (hasDateAndCountry) country[index] else "",
                    onClick = { onClickItem(movieIds[index]) },
                )
            }


        }

    }
}