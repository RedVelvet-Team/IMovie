package com.redvelvet.ui.screen.actor_details

import android.app.Activity
import android.app.StatusBarManager
import android.view.WindowInsets.Side
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MyLocation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import coil.compose.rememberAsyncImagePainter
import com.airbnb.lottie.parser.FloatParser
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.theme.BackgroundOnPrimary
import com.redvelvet.ui.theme.BackgroundPrimary
import com.redvelvet.ui.theme.Shadow1
import com.redvelvet.ui.theme.Shadow2
import com.redvelvet.ui.theme.Shadow3
import com.redvelvet.ui.theme.Shadow4
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing

@Composable
@Preview(showBackground = true)
fun ActorDetailsScreen() {
    ActorDetailsContent()
}

@Composable
private fun ActorDetailsContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimary)
            .verticalScroll(state = rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.image),
                contentDescription = "",
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
                text = "Freddie Highmore",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.color.fontPrimary,
                textAlign = TextAlign.Center
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Actor",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.color.fontPrimary,
            textAlign = TextAlign.Center
        )
        DisplayCard(
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing32,
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16
            )
        )
        DisplayCard(
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing16,
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16
            )
        )
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing24, start = MaterialTheme.spacing.spacing16),
            text = "Known For",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.color.fontPrimary,
            textAlign = TextAlign.Center
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .height(154.dp)
                .padding(top = MaterialTheme.spacing.spacing8),
            state = rememberLazyListState(),
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
            contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
        ) {
            items(count = 10) {
                ItemBasicCard(
                    imagePainter = painterResource(id = R.drawable.image),
                    hasName = true,
                    name = "Freddie"
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing24, start = MaterialTheme.spacing.spacing16),
            text = "Bigoraphy",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.color.fontPrimary,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8, start = MaterialTheme.spacing.spacing16),
            text = "Halle Lynn Bailey (born March 27, 2000)\n" +
                    "is an American singer-songwriter and actress. She became known for being one half of the musical duo Chloe x Halle with her sister ChloeBailey. They have released ...Read more",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.color.fontSecondary,
        )
    }
}

@Composable
fun DisplayCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .background(MaterialTheme.color.backgroundCard)
            .padding(MaterialTheme.spacing.spacing16)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .size(MaterialTheme.spacing.spacing20),
                imageVector = Icons.Outlined.MyLocation,
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(start = MaterialTheme.spacing.spacing8),
                text = "Born",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.color.fontSecondary,
                textAlign = TextAlign.Center
            )

        }

        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
            text = "27 march , 2000(23 years old",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.color.fontSecondary,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing4),
            text = "Atlanta, Georgia",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.color.fontSecondary,
            textAlign = TextAlign.Center
        )

    }
}