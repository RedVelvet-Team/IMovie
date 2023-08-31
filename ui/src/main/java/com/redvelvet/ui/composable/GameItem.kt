package com.redvelvet.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun GameItem(
    onClickItem: () -> Unit,
    icon: ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(MaterialTheme.radius.radius12))
            .background(MaterialTheme.color.backgroundSecondary)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .padding(end = MaterialTheme.spacing.spacing8)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                modifier = Modifier
                    .padding(
                        top = MaterialTheme.spacing.spacing12,
                        bottom = MaterialTheme.spacing.spacing12,
                        start = MaterialTheme.spacing.spacing12
                    ),
                imageVector = icon,
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .padding(
                    start = MaterialTheme.spacing.spacing8,
                    end = MaterialTheme.spacing.spacing12,
                    top = MaterialTheme.spacing.spacing12,
                    bottom = MaterialTheme.spacing.spacing12
                )
                .align(Alignment.CenterVertically)
        ) {
            Text(
                modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing8),
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.color.fontPrimary,
            )
            Text(
                text = description,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.color.fontSecondary
            )
        }
    }
}

@Preview()
@Composable
fun PreviewFunItem() {
    GameItem(
        {},
        icon = ImageVector.vectorResource(R.drawable.ic_movie),
        title = "dddddgggdgdgdhth",
        description = "ijijojojiojiiiiiiiiiouhgtfrdtesessrsujrdfytgyhujkilohgsasdgfghjhjlk"
    )
}