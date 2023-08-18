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
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing

@Composable
fun SeasonsSection(
    isNotListEmpty: Boolean = false,
    seriesId: Int,
    seasonImages: List<String> = emptyList(),
    seasonNames: List<String> = emptyList(),
    seasonIds: List<Int> = emptyList(),
    seasonStars: List<Double> = emptyList(),
    seasonDates: List<String> = emptyList(),
    seasonDescriptions: List<String> = emptyList(),
    seasonEpisodes: List<Int> = emptyList(),
    onClickSeeAllSeasons: () -> Unit = {},
    onClickSeason: (seriesId: Int, seasonId: Int) -> Unit,
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
                name = seasonNames,
                hasCustomList = true,
                hasDateAndCountry = false,
                customListItemComposable = { index ->
                    ItemSeason(
                        id = seasonIds[index],
                        seriesId = seriesId,
                        image = seasonImages[index],
                        name = seasonNames[index],
                        date = seasonDates[index],
                        episodesNum = seasonEpisodes[index],
                        description = seasonDescriptions[index],
                        rate = seasonStars[index],
                        onClickItem = onClickSeason,
                        imagePainter = rememberAsyncImagePainter(
                            model = seasonImages[index],
                            placeholder = painterResource(id = R.drawable.image_placeholder),
                            error = painterResource(id = R.drawable.image_placeholder),
                        )
                    )
                },
                onClickSeeAll = { onClickSeeAllSeasons() },
                cardModifier = Modifier
                    .width(MaterialTheme.dimens.dimens104)
                    .height(MaterialTheme.dimens.dimens130),
            )
        }

}

