package com.redvelvet.ui.screen.known_for

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.rememberAsyncFlixImage
import com.redvelvet.ui.screen.movieDetails.navigateToMovieDetails
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.knownFor.ActorWorksUiState
import com.redvelvet.viewmodel.knownFor.ActorWorksViewModel

@Composable
fun ActorKnownForScreen(
    viewModel: ActorWorksViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    ActorKnownForContent(
        state = state,
        onClickItem = { type: String, id: String ->
            if (type == "movie") navController.navigateToMovieDetails(id)
        }
    )
}

@Composable
private fun ActorKnownForContent(
    state: ActorWorksUiState,
    onClickItem: (String, String) -> Unit
) {
    FlixMovieScaffold(
        title = state.title,
        isLoading = state.isLoading,
        error = state.error,
        hasTopBar = true
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = MaterialTheme.spacing.spacing64)
        ) {
            LazyVerticalGrid(
                contentPadding = PaddingValues(
                    horizontal = MaterialTheme.spacing.spacing16,
                    vertical = MaterialTheme.spacing.spacing64
                ),
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(
                    MaterialTheme.spacing.spacing8,
                    Alignment.CenterHorizontally
                ),
                verticalArrangement = Arrangement.spacedBy(
                    MaterialTheme.spacing.spacing16,
                    Alignment.CenterVertically
                )
            ) {
                items(state.knownFor.size) {
                    val media = state.knownFor[it]
                    ItemBasicCard(
                        imagePainter = rememberAsyncFlixImage(media.imageUrl),
                        hasName = true,
                        name = media.name,
                        modifier = Modifier
                            .width(104.dp)
                            .height(154.dp)
                            .clickable { onClickItem(media.mediaType, media.id.toString()) }
                    )
                }

            }
        }
    }
}