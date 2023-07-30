package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun ItemsSection(
    label: String,
    image: Int,
    hasName: Boolean = false,
    name: String = "",
    hasDateAndCountry: Boolean = false,
    date: String = "",
    country: String = ""
) {
    SectionHeader(label)
    VerticalSpacer(space = 8)
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(10) {
            ItemBasicCard(
                image = image,
                hasName = hasName,
                name = name,
                hasDateAndCountry = hasDateAndCountry,
                date = date,
                country = country
            )
        }
    }
}