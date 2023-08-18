package com.redvelvet.ui.screen.seeall

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.LoadingPage
import com.redvelvet.ui.composable.LoginRequired
import com.redvelvet.ui.composable.MovieScaffold
import com.redvelvet.ui.screen.movieDetails.navigateToMovieDetails
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.seeall.movie.MovieUiState
import com.redvelvet.viewmodel.seeall.movie.SeeAllMovieViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeeAllMovieScreen(
    viewModel: SeeAllMovieViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    MovieScaffold(
        title = state.title,
        isLoading = state.isLoading,
        error = state.error,
        hasTopBar = true,
    ) {
        SeeAllMovieContent(
            movies = state.movies.collectAsLazyPagingItems(),
            onClickCard = { id ->
                Log.v("bug", id)
                navController.navigateToMovieDetails(id)
            }
        )
    }
}

@Composable
private fun SeeAllMovieContent(
    movies: LazyPagingItems<MovieUiState>,
    onClickCard: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
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
            items(movies.itemCount) {
                ItemBasicCard(
                    imagePainter = rememberAsyncImagePainter(model = movies[it]!!.imageUrl),
                    hasName = true,
                    name = movies[it]!!.name,
                    hasDateAndCountry = true,
                    date = movies[it]!!.date,
                    country = movies[it]!!.country,
                    modifier = Modifier
                        .height(MaterialTheme.dimens.dimens176)
                        .width(MaterialTheme.dimens.dimens104)
                        .clickable { onClickCard(movies[it]!!.id) },
                )
            }
            if (movies.loadState.append is LoadState.Loading) {
                item(
                    span = { GridItemSpan(3) }
                ) {
                    LoadingPage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                    )
                }
            }
        }
    }
}