package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens

@Composable
fun AllCategoryItem(
    modifier: Modifier = Modifier,
    media: String,
    genreId: Int
) {
    Card(
        modifier = modifier
            .height(MaterialTheme.dimens.dimens49)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Box(
            modifier = modifier
                .height(MaterialTheme.dimens.dimens49)
                .fillMaxWidth()
                .background(MaterialTheme.color.backgroundSecondary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = media,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = Typography.bodyMedium.copy(color = MaterialTheme.color.fontSecondary),
            )
        }
    }
}

