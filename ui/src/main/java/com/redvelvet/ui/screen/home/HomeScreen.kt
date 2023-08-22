package com.redvelvet.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.TabContentDisplay
import com.redvelvet.ui.screen.movieDetails.navigateToMovieDetails
import com.redvelvet.ui.screen.seeall.navigateToSeeAllMovie
import com.redvelvet.ui.screen.seealltv.navigateSeeAllTvShow
import com.redvelvet.ui.screen.tvshowdetails.navigateToTvShowDetails
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.HomeUiState
import com.redvelvet.viewmodel.home.HomeViewModel
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.utils.SeeAllTvShows

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    FlixMovieScaffold(
        title = "FlixMovie", isLoading = state.isLoading,
        hasTopBar = true,
        hasBackArrow = false,
    ) {
        HomeScreenContent(
            state = state,
            )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreenContent(
    state: HomeUiState,
) {
    Column(
        modifier = Modifier
            .padding(
                top = 92.dp, bottom = MaterialTheme.dimens.dimens70
            )
            .fillMaxWidth()
    ) {

        var page by remember { mutableIntStateOf(0) }
        val pagerState = rememberPagerState(initialPage = 0) {
            if (page == 0) state.movieCategories[0].items.size
            else state.tvShowCategories[0].items.size
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
                {
                    MovieContent(
                        state = state,
                        pagerState = pagerState,
                        "Popular Movies",
                        viewpagerList = state.movieCategories[0].items,
                    )
                }
            }

            1 -> {
                {
                    SeriesContent(
                        state = state,
                        pagerState = pagerState,
                        "Popular Series",
                        state.tvShowCategories[0].items,
                    )
                }
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
fun MovieContent(
    state: HomeUiState,
    pagerState: PagerState,
    label: String,
    viewpagerList: List<ItemUiState>,
) {
    val navController = LocalNavController.current
    TabContentDisplay(
        pagerState = pagerState,
        label = label,
        viewpagerList = viewpagerList,
        categories = state.movieCategories,
        hasName = true,
        hasDateAndCountry = true,
        onClickSeeAll = { seeAllMovie ->
            navController.navigateToSeeAllMovie(
                id = null,
                type = seeAllMovie
            )
        },
        onClickItem = {id ->
            navController.navigateToMovieDetails(id)
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SeriesContent(
    state: HomeUiState,
    pagerState: PagerState,
    label: String,
    viewpagerList: List<ItemUiState>,
) {
    val navController = LocalNavController.current
    TabContentDisplay(
        pagerState = pagerState,
        viewpagerList = viewpagerList,
        label = label,
        categories = state.tvShowCategories,
        hasName = true,
        hasDateAndCountry = true,
        onClickSeeAll = {
            navController.navigateSeeAllTvShow(id=null, type = SeeAllTvShows.TOP_RATED)
        },
        onClickItem = { id ->
            navController.navigateToTvShowDetails(id)
        }
    )
}

