package com.redvelvet.ui.screen.movieDetails.mediaComposable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.composable.CircularImageAvatar
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.screen.movieDetails.MovieDetailsUiEvent
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun TopCastSection(
    it: List<MovieDetailsScreenUiState.MovieTopCastUiState>,
    uiEvent: MovieDetailsUiEvent
) {
    ItemsSection(
        label = "Top Cast",
        images = it.map { it2 -> it2.castImage },
        hasName = true,
        name = it.map { it2 -> it2.castName },
        hasCustomList = true,
        customListItemComposable = { index, image ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { uiEvent.onCast(it[index].castId) }
            ) {
                CircularImageAvatar(imageUrl = image)
                SpacerVertical(height = MaterialTheme.spacing.spacing4)
                Box(
                    modifier = Modifier
                        .width(70.dp)
                ) {
                    Text(
                        text = it[index].castName,
                        style = MaterialTheme.typography.bodySmall,
                        color = OnSecondary,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        },
        onClickSeeAll = { uiEvent.onTopCastSeeAll() },
        onClickItem = { uiEvent.onCast(0) }

    )
}