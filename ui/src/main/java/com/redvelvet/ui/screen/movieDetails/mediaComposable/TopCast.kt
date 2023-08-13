package com.redvelvet.ui.screen.movieDetails.mediaComposable

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.composable.CircularImageAvatar
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.movieDetails.MovieDetailsInteraction
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState

@Composable
fun TopCast(
    it: List<MovieDetailsScreenUiState.MovieTopCastUiState>,
    index: Int,
    image: String,
    interaction: MovieDetailsInteraction,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { interaction.onClickCast(it[index].castId) }
    ) {
        CircularImageAvatar(image = image)
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

}
