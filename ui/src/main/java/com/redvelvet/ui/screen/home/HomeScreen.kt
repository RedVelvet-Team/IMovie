package com.redvelvet.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.composable.CustomTabLayout
import com.redvelvet.ui.composable.CustomTopAppBar
import com.redvelvet.ui.composable.ItemsSection
import com.redvelvet.ui.composable.VerticalSpacer
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.HomeUiState
import com.redvelvet.viewmodel.home.HomeViewModel

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewHomeScreenVertical() {
    val navController = rememberNavController()
    HomeScreen(navController)
}

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        CustomTopAppBar("FlixMovie", hasBackArrow = false)
    }, bottomBar = {
        //TODO @Hassan Ayman
    },
        containerColor = Primary
    ) { paddingValues ->
        HomeScreenContent(paddingValues, state)
    }
}

@Composable
fun HomeScreenContent(paddingValues: PaddingValues, state: HomeUiState) {
    Column(
        modifier = Modifier
            .padding(top = 64.dp)
            .fillMaxWidth()
    ) {
        CustomTabLayout()
        LazyColumn(contentPadding = PaddingValues(vertical = MaterialTheme.spacing.spacing16)) {
            item {
                ItemsSection(
                    label = "Popular Movies",
                    images = listOf(state.popularMovie?.movieImage!!),
                    hasName = true,
                    name = listOf(state.popularMovie?.movieName!!),
                    hasDateAndCountry = false,
                    date = listOf(state.popularMovie?.movieDate!!),
                    country = listOf(state.popularMovie?.countryOfMovie!!)
                )
            }
            item {
                VerticalSpacer(space = 24)
                ItemsSection(
                    label = "Up Coming",
                    images = state.upComingMovies.map { it.movieImage },
                    hasName = true,
                    name = state.upComingMovies.map { it.movieName },
                    hasDateAndCountry = true,
                    date = state.upComingMovies.map { it.movieDate },
                    country = state.upComingMovies.map { it.countryOfMovie }
                )
            }
            item {
                VerticalSpacer(space = 24)
                ItemsSection(
                    label = "Top Rated",
                    images = state.upComingMovies.map { it.movieImage },
                    hasName = true,
                    name = state.upComingMovies.map { it.movieName },
                    hasDateAndCountry = true,
                    date = state.upComingMovies.map { it.movieDate },
                    country = state.upComingMovies.map { it.countryOfMovie }
                )
            }
        }

    }
}





