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
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun ItemsSection(
    label: String,
    images: List<String>,
    hasName: Boolean = false,
    name: List<String> = emptyList(),
    hasDateAndCountry: Boolean = false,
    date: List<String> = emptyList(),
    country: List<String> = emptyList()
) {
    SectionHeader(label)
    LazyRow(
        modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        itemsIndexed(images) { index, image ->
            ItemBasicCard(
                imagePainter = rememberAsyncImagePainter(model = image),
                modifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
                hasName = hasName,
                name = name[index],
                hasDateAndCountry = hasDateAndCountry,
                date = date[index],
                country = country[index]
            )
        }
    }
}