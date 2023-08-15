package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

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
import com.redvelvet.ui.composable.SpacerVertical
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction
import com.redvelvet.viewmodel.tvshow.TvShowTopCastUiState

@Composable
fun TvShowTopCast(
    it: List<TvShowTopCastUiState>,
    index: Int,
    image: String,
    interaction: TvShowDetailsInteraction,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { interaction.onClickCast(it[index].id) }
    ) {
        CircularImageAvatar(image = image)
        SpacerVertical(height = MaterialTheme.spacing.spacing4)
        Box(
            modifier = Modifier
                .width(70.dp)
        ) {
            Text(
                text = it[index].name,
                style = MaterialTheme.typography.bodySmall,
                color = OnSecondary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }

}
