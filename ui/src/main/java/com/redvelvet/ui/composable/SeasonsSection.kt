package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.R
import com.redvelvet.ui.screen.movieDetails.Item
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun SeasonsSection(
    isNotListEmpty: Boolean = false,
    seriesId: Int,
    items: List<Item> = emptyList(),
    onClickSeeAllSeasons: (String) -> Unit = {},
    onClickSeason: (String, Int) -> Unit,
) {
    if (isNotListEmpty)
        Column(
            modifier = Modifier
                .padding(
                    bottom = MaterialTheme.spacing.spacing24,
                )
        ) {
            ItemsSectionForDetailsScreens(
                label = "Seasons",
                hasName = false,
                items = items,
                hasCustomList = true,
                hasDateAndCountry = false,
                customListItemComposable = { index ->
                    val item = items[index]
                    ItemSeason(
                        // TODO: seasonNumber
                        seasonNumber = 0,
                        seriesId = item.id.toString(),
                        name = item.name,
                        date = item.date,
                        episodesNum = item.episodeNum,
                        description = item.discription,
                        rate = item.stars,
                        onClickItem = onClickSeason,
                        image = rememberAsyncImagePainter(
                            model = item.image,
                            placeholder = painterResource(id = R.drawable.image_placeholder),
                            error = painterResource(id = R.drawable.image_placeholder),
                        )
                    )
                },
                onClickSeeAll = { onClickSeeAllSeasons(seriesId.toString()) },
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
                itemId = seriesId.toString()
            )
        }
}