package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.home.ItemsUiState
import com.redvelvet.viewmodel.utils.MediaType
import com.redvelvet.viewmodel.utils.SeeAllMovie
import com.redvelvet.viewmodel.utils.SeeAllTvShows

@Composable
fun ItemsSection(
    modifier: Modifier = Modifier,
    hasName: Boolean = false,
    hasDateAndCountry: Boolean = false,
    seeAllMovie: SeeAllMovie,
    onClickSeeAllMovie: (SeeAllMovie) -> Unit = {},
    onClickItem: (String) -> Unit,
    items: ItemsUiState,
    onClickSeeAllTv: (SeeAllTvShows) -> Unit = {},
    type: MediaType,
    seeAllTv: SeeAllTvShows
) {
    SectionHeader(
        label = items.title,
        modifier = modifier,
        onClickSeeAllMovie = onClickSeeAllMovie,
        onClickSeeAllTv = onClickSeeAllTv,
        type = type,
        seeAllMovie = seeAllMovie,
        seeAllTv = seeAllTv,
    )
    LazyRow(
        modifier = Modifier.padding(top = MaterialTheme.dimens.dimens8),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.dimens8),
        contentPadding = PaddingValues(horizontal = MaterialTheme.dimens.dimens16)
    ) {
        items(items.items.size) {
            val item = items.items[it]
            ItemBasicCard(
                imagePainter = rememberAsyncFlixImage(image = item.image),
                modifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens176)
                    .clickable {
                        onClickItem(item.id)
                    },
                hasName = hasName,
                name = item.name,
                hasDateAndCountry = hasDateAndCountry,
                date = item.date,
                country = item.country
            )
        }
    }
}