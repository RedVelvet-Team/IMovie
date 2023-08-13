package com.redvelvet.ui.screen.seeall

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.MovieUiState
import com.redvelvet.viewmodel.seeall.movie.SeeAllMovieViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeeAllMovieScreen(
    viewModel: SeeAllMovieViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { FilxTopAppBar( state.title, hasBackArrow = true) },
        containerColor = MaterialTheme.color.backgroundPrimary
    ) {
        SeeAllMovieContent(
           state.movies.collectAsLazyPagingItems()
        )
    }
}

@Composable
private fun SeeAllMovieContent(movies: LazyPagingItems<MovieUiState>) {
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
            items(movies.itemCount) {
                ItemBasicCard(
                    imagePainter = rememberAsyncImagePainter(model = movies[it]!!.movieImage),
                    hasName = true,
                    name = movies[it]!!.movieName,
                    hasDateAndCountry = true,
                    date = movies[it]!!.movieDate,
                    country = movies[it]!!.countryOfMovie
                )
            }
        }
    }
}