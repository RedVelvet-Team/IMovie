package com.redvelvet.ui.screen.see_all_episodes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.EpisodeItem
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.screen.episode.navigateToEpisodeDetails
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.see_all_episode.EpisodesViewModel
import com.redvelvet.viewmodel.see_all_episode.SeeAllEpisodeUiState

@Composable
fun SeeAllEpisodeScreen(
    viewModel: EpisodesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    val navController = LocalNavController.current

    FlixMovieScaffold(
        title = state.title,
        isLoading = state.isLoading,
        error = state.error,
        modifier = Modifier.fillMaxWidth(),
        hasBackArrow = true,
        hasTopBar = true
    ) {
        SeeAllEpisodeContent(seeAllEpisodeUiState = state,
            onClickEpisode = {
                navController.navigateToEpisodeDetails(
                    tvId = (1396).toString(),
                    seasonNumber = 1,
                    episodeNumber = 1
                )
            }
        )
    }
}


@Composable
fun SeeAllEpisodeContent(
    seeAllEpisodeUiState: SeeAllEpisodeUiState,
    onClickEpisode: (id: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
            .padding(
                top = MaterialTheme.spacing.spacing72,
                bottom = MaterialTheme.spacing.spacing28
            )
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
                vertical = MaterialTheme.spacing.spacing24
            ),
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.spacing16,
                Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.Start,
        ) {
            items(seeAllEpisodeUiState.episodes.size) { index ->
                val episode = seeAllEpisodeUiState.episodes[index]
                EpisodeItem(
                    name = episode.name,
                    rate = episode.voteAverage,
                    date = episode.airDate,
                    durationTime = episode.runtime,
                    image = episode.image,
                   onClickEpisode= onClickEpisode,
                    id = episode.id.toString()
                )
            }
        }
    }
}
