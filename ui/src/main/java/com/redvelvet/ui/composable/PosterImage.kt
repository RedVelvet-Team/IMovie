package com.redvelvet.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.redvelvet.ui.R
import com.redvelvet.ui.theme.BackgroundPrimary
import com.redvelvet.ui.theme.Shadow1
import com.redvelvet.ui.theme.Shadow2
import com.redvelvet.ui.theme.Shadow3
import com.redvelvet.ui.theme.Shadow4
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing

@Composable
fun PosterImage(
    name: String,
    posterImage: Painter
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp),
            painter = posterImage,
            contentDescription = name,
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Shadow1,
                            Shadow2,
                            Shadow3,
                            Shadow4,
                            BackgroundPrimary
                        ),
                    )
                )
        )
        Text(
            modifier = Modifier.align(Alignment.BottomCenter),
            text = name,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.color.fontPrimary,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun BirthCard(
    birthDate: String,
    birthLocation: String,
    modifier: Modifier = Modifier,
) {
    DisplayCard(
        iconPainter = painterResource(id = R.drawable.icon_location),
        title = stringResource(R.string.born),
        text = birthDate,
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing4),
            text = birthLocation,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.color.fontSecondary,
            textAlign = TextAlign.Center
        )

    }
}