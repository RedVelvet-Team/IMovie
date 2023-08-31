package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
fun ImageAndText(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    title: String,
    description: String,
    onClick:()->Unit = {}
) {
    val shape = RoundedCornerShape(MaterialTheme.radius.radius16)
    val height = MaterialTheme.spacing.spacing200
    Box(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.spacing.spacing12
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape)
        )

        Icon(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = MaterialTheme.spacing.spacing44),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_room),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(
                    top = MaterialTheme.spacing.spacing100,
                    start = MaterialTheme.spacing.spacing16,
                    end = MaterialTheme.spacing.spacing16
                )
                .align(Alignment.TopCenter)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = title,
                color = MaterialTheme.color.fontPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.spacing12)
                    .align(Alignment.CenterHorizontally),
                text = description,
                color = MaterialTheme.color.fontSecondary,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}


//@Preview(showSystemUi = true)
//@Composable
//fun PreviewFunScreen() {
//    ImageAndText(
//        painter = painterResource(id = R.drawable.room_placeholder),
//        contentDescription = "room placeholder",
//        title = "Share the Entertainment!",
//        description = "You can create a room and invite your friends to watch movies together :)"
//    )
//}