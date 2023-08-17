package com.redvelvet.ui.screen.seeall.seasons

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.ItemSeason
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.seeall.seasons.SeeAllSeasonsUiState
import com.redvelvet.viewmodel.seeall.seasons.SeeAllSeasonsViewModel

@Composable
fun SeeAllSeasonsScreen(
    viewModel: SeeAllSeasonsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    MovieScaffold(
        title = "Seasons",
        isLoading = state.isLoading,
        error = state.error,
        modifier = Modifier.fillMaxWidth(),
        hasBackArrow = true,
        hasTopBar = true
    ) {
        SeeAllSeasonsContent(state)
    }
}

@Composable
fun SeeAllSeasonsContent(state: SeeAllSeasonsUiState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
            .padding(top = MaterialTheme.spacing.spacing72)
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
                vertical = MaterialTheme.spacing.spacing16
            )
        ) {
            items(state.seasons.size) { index ->
                val seasons = state.seasons[index]
                ItemSeason(
                    imagePainter = rememberAsyncImagePainter(
                        model = seasons?.imageUrl,
                    ),
                    name = "season ${seasons?.seasonNumber}",
                    date = seasons!!.airDate,
                    episodesNum = seasons.episodesNum,
                    description = seasons.description,
                    rate = seasons.rate
                )
            }
        }
    }
}