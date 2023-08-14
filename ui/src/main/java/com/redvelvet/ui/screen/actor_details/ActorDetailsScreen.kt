package com.redvelvet.ui.screen.actor_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.theme.BackgroundPrimary
import com.redvelvet.ui.theme.Shadow1
import com.redvelvet.ui.theme.Shadow2
import com.redvelvet.ui.theme.Shadow3
import com.redvelvet.ui.theme.Shadow4
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.actor_details.ActorDetailsUiState
import com.redvelvet.viewmodel.actor_details.ActorDetailsViewModel

@Composable
@Preview(showBackground = true)
fun ActorDetailsScreen(
    viewModel: ActorDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ActorDetailsContent(state)
}

@Composable
private fun ActorDetailsContent(state: ActorDetailsUiState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundPrimary)
            .verticalScroll(state = rememberScrollState())
            .padding(bottom = MaterialTheme.spacing.spacing24)
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
                contentDescription = state.name,
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
                text = state.name,
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.color.fontPrimary,
                textAlign = TextAlign.Center
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = state.knownForDepartment,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.color.fontPrimary,
            textAlign = TextAlign.Center
        )
        BirthCard(
            birthDate = state.birthDate,
            birthLocation = state.birthLocation,
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing32,
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16
            )
        )
        DisplayCard(
            iconPainter = painterResource(id = R.drawable.icon_game),
            title = stringResource(R.string.known_as),
            text = state.knownAs,
            modifier = Modifier.padding(
                top = MaterialTheme.spacing.spacing16,
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16
            )
        )
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing24, start = MaterialTheme.spacing.spacing16),
            text = stringResource(R.string.known_for),
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
            text = stringResource(R.string.biography),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.color.fontPrimary,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8, start = MaterialTheme.spacing.spacing16),
            text = state.biography,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.color.fontSecondary,
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
        iconPainter = painterResource(id = R.drawable.icon_game),
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

@Composable
fun DisplayCard(
    iconPainter: Painter,
    title: String,
    text: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
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
                painter = iconPainter,
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(start = MaterialTheme.spacing.spacing8),
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.color.fontSecondary,
                textAlign = TextAlign.Center
            )

        }

        Text(
            modifier = Modifier.padding(top = MaterialTheme.spacing.spacing8),
            text = text,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.color.fontSecondary,
            textAlign = TextAlign.Center
        )
        content()
    }
}