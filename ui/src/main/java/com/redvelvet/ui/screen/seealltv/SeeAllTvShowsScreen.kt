package com.redvelvet.ui.screen.seealltv

import androidx.compose.foundation.background
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.TvShowUiState
import com.redvelvet.viewmodel.seeall.tv.SeeAllTvViewModel

@Composable
fun SeeAllTvScreen(
    viewModel: SeeAllTvViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)

    MovieScaffold(
        modifier = Modifier.fillMaxSize(),
        title = state.title,
        isLoading = false,
    ) {
        SeeAllTvShowsContent(state.tvShows.collectAsLazyPagingItems())
    }
}

@Composable
private fun SeeAllTvShowsContent(tvShow: LazyPagingItems<TvShowUiState>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
            .padding(top = MaterialTheme.spacing.spacing64)
    ) {
        LazyVerticalGrid(
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
                vertical = MaterialTheme.spacing.spacing24
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
            items(tvShow.itemCount) {
                ItemBasicCard(
                    imagePainter = rememberAsyncImagePainter(model = tvShow[it]!!.seriesImage),
                    modifier = Modifier
                        .height(MaterialTheme.dimens.dimens176)
                        .width(MaterialTheme.dimens.dimens104),
                    hasName = true,
                    name = tvShow[it]!!.seriesName,
                    hasDateAndCountry = true,
                    date = tvShow[it]!!.seriesDate,
                    country = tvShow[it]!!.seriesCountry
                )
            }
        }

    }
}