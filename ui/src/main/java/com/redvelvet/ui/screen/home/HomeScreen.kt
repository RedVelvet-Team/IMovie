package com.redvelvet.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.composable.FilxTabLayout
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.TabContentDisplay
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.HomeUiState
import com.redvelvet.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            FilxTopAppBar(
                "FlixMovie",
                hasBackArrow = false
            )
        }, bottomBar = {
        },
        containerColor = MaterialTheme.color.backgroundPrimary
    ) { paddingValues ->
        HomeScreenContent(paddingValues, state)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(
    paddingValues: PaddingValues, state: HomeUiState
) {
    Column(
        modifier = Modifier
            .padding(
                top = MaterialTheme.spacing.spacing64, bottom = MaterialTheme.dimens.dimens70
            )
            .fillMaxWidth()
    ) {
        val pagerState = rememberPagerState { state.tabLayoutTitles.size }
        FilxTabLayout(pagerState = pagerState, titles = state.tabLayoutTitles)
        HorizontalPager(state = pagerState) { currentPage ->
            AnimatedVisibility(currentPage == 0) {
                TabContentDisplay(
                    categories = state.movieCategories,
                    titles = state.movieCategories.map { movieCategoryUiState -> movieCategoryUiState.title },
                    imagePainters = state.movieCategories.map { movieCategoryUiState ->
                        movieCategoryUiState.movies.map { movieUiState ->
                            rememberAsyncImagePainter(model = movieUiState.movieImage)
                        }
                    },
                    hasName = true,
                    hasDateAndCountry = true,
                    names = state.movieCategories.map { movieCategoryUiState ->
                        movieCategoryUiState.movies.map { movieUiState ->
                            movieUiState.movieName
                        }
                    },
                    dates = state.movieCategories.map { movieCategoryUiState ->
                        movieCategoryUiState.movies.map { movieUiState ->
                            movieUiState.movieDate
                        }
                    },
                    countries = state.movieCategories.map { movieCategoryUiState ->
                        movieCategoryUiState.movies.map { movieUiState ->
                            movieUiState.countryOfMovie
                        }
                    },
                )
            }
            AnimatedVisibility(visible = currentPage != 0) {
                TabContentDisplay(
                    categories = state.tvShowCategories,
                    titles = state.tvShowCategories.map { tvShowCategory -> tvShowCategory.title },
                    imagePainters = state.tvShowCategories.map { tvShowCategoryUiState ->
                        tvShowCategoryUiState.tvShows.map { tvShowUiState ->
                            rememberAsyncImagePainter(model = tvShowUiState.seriesImage)
                        }
                    },
                    hasName = true,
                    hasDateAndCountry = true,
                    names = state.tvShowCategories.map { tvShowCategoryUiState ->
                        tvShowCategoryUiState.tvShows.map { tvShowUiState ->
                            tvShowUiState.seriesName
                        }
                    },
                    dates = state.tvShowCategories.map { tvShowCategoryUiState ->
                        tvShowCategoryUiState.tvShows.map { tvShowUiState ->
                            tvShowUiState.seriesDate
                        }
                    },
                    countries = state.tvShowCategories.map { tvShowCategoryUiState ->
                        tvShowCategoryUiState.tvShows.map { tvShowUiState ->
                            tvShowUiState.seriesCountry
                        }
                    },
                )
            }
        }
    }
}