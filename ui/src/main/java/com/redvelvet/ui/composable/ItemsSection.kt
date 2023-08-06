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
    images: List<Painter>,
    headerModifier: Modifier = Modifier,
    hasName: Boolean = false,
    name: List<String> = emptyList(),
    hasDateAndCountry: Boolean = false,
    date: List<String> = emptyList(),
    country: List<String> = emptyList()
) {
    SectionHeader(label, modifier = headerModifier)
    LazyRow(
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        items(images.size) {
            ItemBasicCard(
                imagePainter = images[it],
                modifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
                hasName = hasName,
                name = if(name.isNotEmpty()) name[it] else "",
                hasDateAndCountry = hasDateAndCountry,
                date = if(date.isNotEmpty()) date[it] else "",
                country = if(country.isNotEmpty()) country[it] else ""
            )
        }
    }
}