package com.redvelvet.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
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

        var page by remember { mutableIntStateOf(0) }
        val pagerState = rememberPagerState(initialPage = 1) {
            1
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.spacing16)
        ) {
            TabRow(
                selectedTabIndex = page,
                containerColor = MaterialTheme.color.backgroundPrimary,
                indicator = {
                },
                divider = {}
            ) {
                state.tabLayoutTitles.forEachIndexed { index, title ->
                    Box {
                        Tab(
                            selected = page == index,
                            onClick = {
                                page = index
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
                            visible = page == index,
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
        val selectedTabContent: @Composable () -> Unit = when (page) {
            0 -> {
                { MovieContent(state = state, pagerState = pagerState) }
            }

            1 -> {
                { SeriesContent(state = state, pagerState = pagerState) }
            }

            else -> {
                {}
            }
        }
        selectedTabContent()
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieContent(state: HomeUiState, pagerState: PagerState) {
    TabContentDisplay(
        pagerState = pagerState,
        categories = state.movieCategories,
        titles = state.movieCategories.map { movieCategoryUiState -> movieCategoryUiState.title },
        imagePainters = state.movieCategories.map { movieCategoryUiState ->
            movieCategoryUiState.movies.map { movieUiState ->
                rememberAsyncImagePainter(model = movieUiState.imageUrl)
            }
        },
        hasName = true,
        hasDateAndCountry = true,
        names = state.movieCategories.map { movieCategoryUiState ->
            movieCategoryUiState.movies.map { movieUiState ->
                movieUiState.name
            }
        },
        dates = state.movieCategories.map { movieCategoryUiState ->
            movieCategoryUiState.movies.map { movieUiState ->
                movieUiState.date
            }
        },
        countries = state.movieCategories.map { movieCategoryUiState ->
            movieCategoryUiState.movies.map { movieUiState ->
                movieUiState.country
            }
        },
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SeriesContent(state: HomeUiState, pagerState: PagerState) {
    TabContentDisplay(
        pagerState = pagerState,
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

