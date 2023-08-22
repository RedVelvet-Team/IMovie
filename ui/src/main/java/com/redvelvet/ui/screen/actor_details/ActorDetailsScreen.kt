package com.redvelvet.ui.screen.actor_details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.BirthCard
import com.redvelvet.ui.composable.DisplayCard
import com.redvelvet.ui.composable.ExpandableText
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.PosterImage
import com.redvelvet.ui.composable.SeeMoreList
import com.redvelvet.ui.screen.known_for.navigateToActorKnownFor
import com.redvelvet.ui.screen.movieDetails.navigateToMovieDetails
import com.redvelvet.ui.theme.BackgroundPrimary
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.actor_details.ActorDetailsUiState
import com.redvelvet.viewmodel.actor_details.ActorDetailsViewModel

@Composable
fun ActorDetailsScreen(
    viewModel: ActorDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        Color.Transparent
    )
    ActorDetailsContent(
        state = state,
        onClickSeeAll = { navController.navigateToActorKnownFor(state.id) },
        onClickItem = { type: String, id: String ->
            if (type == "movie") navController.navigateToMovieDetails(id)
        }
    )
}

@Composable
private fun ActorDetailsContent(
    state: ActorDetailsUiState,
    onClickSeeAll: () -> Unit,
    onClickItem: (String, String) -> Unit
) {
    FlixMovieScaffold(
        isLoading = state.isLoading,
        error = state.error,
    ) {
        Column(
            modifier = Modifier
                .background(BackgroundPrimary)
                .verticalScroll(state = rememberScrollState())
                .padding(bottom = MaterialTheme.spacing.spacing24)
        ) {

            PosterImage(
                name = state.name,
                posterImage = rememberAsyncImagePainter(model = state.imageUrl)
            )

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
                iconPainter = painterResource(id = R.drawable.icon_known_as),
                title = stringResource(R.string.known_as),
                text = state.knownAs,
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.spacing16,
                    start = MaterialTheme.spacing.spacing16,
                    end = MaterialTheme.spacing.spacing16
                )
            )

            SeeMoreList(
                onClickSeeAll = onClickSeeAll,
                title = stringResource(id = R.string.known_for),
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.spacing24,
                    start = MaterialTheme.spacing.spacing16,
                    end = MaterialTheme.spacing.spacing16,
                )
            )

            LazyRow(
                modifier = Modifier
                    .padding(top = MaterialTheme.spacing.spacing8),
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
                contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.spacing16)
            ) {
                items(count = state.knownFor.size) {
                    val media = state.knownFor[it]
                    ItemBasicCard(
                        imagePainter = rememberAsyncImagePainter(media.imageUrl),
                        hasName = true,
                        name = media.name,
                        modifier = Modifier
                            .width(104.dp)
                            .height(154.dp)
                            .clickable { onClickItem(media.mediaType, media.id.toString()) }
                    )
                }
            }
            Text(
                modifier = Modifier.padding(
                    top = MaterialTheme.spacing.spacing24,
                    start = MaterialTheme.spacing.spacing16
                ),
                text = stringResource(R.string.biography),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.color.fontPrimary,
                textAlign = TextAlign.Center
            )
            ExpandableText(
                text = state.biography,
                modifier = Modifier.padding(
                    vertical = MaterialTheme.spacing.spacing8,
                    horizontal = MaterialTheme.spacing.spacing16
                )
            )
        }
    }
}