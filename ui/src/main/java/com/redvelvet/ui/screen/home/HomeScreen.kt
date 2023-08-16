package com.redvelvet.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.redvelvet.ui.composable.FilxTopAppBar
import com.redvelvet.ui.composable.TabContentDisplay
import com.redvelvet.ui.theme.Typography
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
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        FilxTopAppBar(
            "FlixMovie", hasBackArrow = false
        )
    }, bottomBar = {}, containerColor = MaterialTheme.color.backgroundPrimary
    ) { paddingValues ->
        HomeScreenContent(paddingValues, state)
    }
}
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

        var pagerState by remember { mutableIntStateOf(0) }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.spacing16)
        ) {
            TabRow(
                selectedTabIndex = pagerState,
                containerColor = MaterialTheme.color.backgroundPrimary,
                indicator = {
                },
                divider = {}
            ) {
                state.tabLayoutTitles.forEachIndexed { index, title ->
                    Box {
                        Tab(
                            selected = pagerState == index,
                            onClick = {
                                pagerState = index
                            },
                            text = {
                                Text(
                                    text = title,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = Color.White,
                                    style = Typography.headlineSmall
                                )
                            })
                        this@Column.AnimatedVisibility(
                            visible = pagerState == index,
                            modifier = Modifier.align(Alignment.BottomCenter)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.4f)
                                    .height(MaterialTheme.dimens.dimens4)
                                    .align(Alignment.BottomCenter)
                                    .background(
                                        MaterialTheme.color.brand100,
                                        RoundedCornerShape(50)
                                    )
                            )
                        }
                    }
                }
            }
        }
        val selectedTabContent: @Composable () -> Unit = when (pagerState) {
            0 -> {
                { MovieContent(state = state) }
            }

            1 -> {
                { SeriesContent(state = state) }
            }

            else -> {
                {}
            }
        }
        selectedTabContent()
    }
}


@Composable
fun MovieContent(state: HomeUiState) {
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

@Composable
fun SeriesContent(state: HomeUiState) {
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

