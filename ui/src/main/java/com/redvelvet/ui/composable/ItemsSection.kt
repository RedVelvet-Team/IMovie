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
import androidx.compose.ui.graphics.painter.Painter
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun ItemsSection(
    label: String,
    imagesPainters: List<Painter>,
    modifier: Modifier = Modifier,
    hasName: Boolean = false,
    names: List<String> = emptyList(),
    hasDateAndCountry: Boolean = false,
    dates: List<String> = emptyList(),
    countries: List<String> = emptyList()
) {
    SectionHeader(label = label, modifier = modifier)
    LazyRow(
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        items(imagesPainters.size) {
            ItemBasicCard(
                imagePainter = imagesPainters[it],
                modifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens176),
                hasName = hasName,
                name = if (names.isNotEmpty()) names[it] else "",
                hasDateAndCountry = hasDateAndCountry,
                date = if (dates.isNotEmpty()) dates[it] else "",
                country = if (countries.isNotEmpty()) countries[it] else ""
            )
        }
    }
}