@file:Suppress("LABEL_NAME_CLASH")

package com.redvelvet.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.ErrorPage
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.composable.TabContentDisplay
import com.redvelvet.ui.screen.movieDetails.navigateToMovieDetails
import com.redvelvet.ui.screen.seeall.navigateToSeeAllMovie
import com.redvelvet.ui.screen.seealltv.navigateSeeAllTvShow
import com.redvelvet.ui.screen.tvshowdetails.navigateToTvShowDetails
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.home.HomeInteraction
import com.redvelvet.viewmodel.home.HomeUiEffect
import com.redvelvet.viewmodel.home.HomeUiState
import com.redvelvet.viewmodel.home.HomeViewModel
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.utils.MediaType

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    NavigationHandler(
        effects = viewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is HomeUiEffect.NavigateUp -> {
                    navController.popBackStack()
                }
            }
        }
    )
    FlixMovieScaffold(
        title = "FlixMovie",
        isLoading = state.isLoading,
        error = state.isError,
        hasTopBar = true,
        hasBackArrow = false,
    ) {
        if (state.isEmpty) {
            HomeContent(state = state, interaction = viewModel)
        } else {
            ErrorPage(
                image = painterResource(id = R.drawable.vector_no_internet),
                title = "Internet is not available",
                description = "Please make sure you are connected to the internet and try again",
                retryButton = { viewModel.onCLickRefresh() })
        }

    }
}

@Composable
fun HomeContent(
    state: HomeUiState,
    interaction: HomeInteraction,
) {
    Column(
        modifier = Modifier
            .padding(
                top = 92.dp, bottom = MaterialTheme.dimens.dimens70
            )
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.dimens.dimens16)
        ) {
            TabRow(
                selectedTabIndex = state.type.ordinal,
                containerColor = MaterialTheme.color.backgroundPrimary,
                indicator = {},
                divider = {}
            ) {
                MediaType.entries.forEachIndexed { index, items ->
                    Box {
                        Tab(
                            selected = state.type == items,
                            onClick = { interaction.onChangeCategoryTab(items) },
                            text = {
                                Text(
                                    text = items.name,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = Color.White,
                                    style = Typography.headlineSmall
                                )
                            })
                        this@Column.AnimatedVisibility(
                            visible = state.type == items,
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
        val selectedTabContent: @Composable () -> Unit = {
            when (state.type) {
                MediaType.MOVIE -> MovieContent(
                    state = state,
                    viewpagerList = if (state.movieCategories.isNotEmpty()) state.movieCategories[0].items else listOf()
                )

                MediaType.TV -> SeriesContent(
                    state = state,
                    viewpagerList = if (state.tvShowCategories.isNotEmpty()) state.tvShowCategories[0].items else listOf()
                )

                else -> {}
            }
        }
        selectedTabContent()
    }
}

@Composable
fun MovieContent(
    state: HomeUiState,
    viewpagerList: List<ItemUiState>,
) {
    val navController = LocalNavController.current
    TabContentDisplay(
        viewpagerList = viewpagerList,
        categories = state.movieCategories,
        label = state.label,
        hasName = true,
        hasDateAndCountry = true,
        onClickSeeAllMovie = { seeAllMovie ->
            navController.navigateToSeeAllMovie(
                id = null,
                type = seeAllMovie
            )
        },
        onClickItem = { id ->
            navController.navigateToMovieDetails(id)
        },
        type = MediaType.MOVIE,
        onClickSeeAllTv = {}
    )
}
@Composable
fun SeriesContent(
    state: HomeUiState,
    viewpagerList: List<ItemUiState>,
) {
    val navController = LocalNavController.current
    TabContentDisplay(
        viewpagerList = viewpagerList,
        label = state.label,
        categories = state.tvShowCategories,
        hasName = true,
        hasDateAndCountry = true,
        type = MediaType.TV,
        onClickSeeAllMovie = {},
        onClickSeeAllTv = {
            navController.navigateSeeAllTvShow(id = null, type = it)
        },
        onClickItem = { id ->
            navController.navigateToTvShowDetails(id)
        }
    )
}