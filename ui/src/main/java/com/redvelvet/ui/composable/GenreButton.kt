package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import com.redvelvet.ui.theme.FontPrimary
import com.redvelvet.ui.theme.OnSecondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun GenreButton(genre: String, onGenreClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(end = MaterialTheme.spacing.spacing8),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
                .height(MaterialTheme.dimens.dimens24)
                .clickable { onGenreClick(genre) }
                .background(OnSecondary),
        ) {
            Text(
                text = genre,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(
                        horizontal = MaterialTheme.spacing.spacing8,
                        vertical = MaterialTheme.spacing.spacing4
                    ),
                style = Typography.labelSmall.copy(
                    color = FontPrimary,
                )
            )
        }
    }
}
