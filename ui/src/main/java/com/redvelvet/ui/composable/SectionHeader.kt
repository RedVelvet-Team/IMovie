package com.redvelvet.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.utils.SeeAllMovie

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    label: String,
    onClickSeeAll: (SeeAllMovie) -> Unit = {},
    seeAllMovie: SeeAllMovie,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        Text(
            text = label,
            style = Typography.titleMedium,
            color = Color.White
        )
        Text(text = "see all",
            style = Typography.labelSmall,
            color = MaterialTheme.color.fontAccent,
            modifier = Modifier.clickable { onClickSeeAll(seeAllMovie) }
        )
    }
}