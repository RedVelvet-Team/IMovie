package com.redvelvet.ui.screen.category

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.CategoryItem
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.category.CategoryInteraction
import com.redvelvet.viewmodel.category.CategoryUiEffect
import com.redvelvet.viewmodel.category.CategoryViewModel
import com.redvelvet.viewmodel.category.GenreUiState
import com.redvelvet.viewmodel.category.MediaTypeUiState
import com.redvelvet.viewmodel.utils.MediaType

@Composable
fun CategoryScreen(categoryViewModel: CategoryViewModel = hiltViewModel()) {

    val state by categoryViewModel.state.collectAsState()
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    NavigationHandler(
        effects = categoryViewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is CategoryUiEffect.NavigateUp -> {
                    navController.popBackStack()
                }

//                is CategoryUiEffect.NavigateToSeeAllCategoryScreen -> {
//                    navController.navigateToSeeAllCategory(effect.id)
//                }
            }
        }
    )
    FlixMovieScaffold(
        title = "Category",
        isLoading = false,
        hasTopBar = true,
        hasBackArrow = false
    ) {
        CategoryContent(state = MediaTypeUiState(), interaction = categoryViewModel)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryContent(
    state: MediaTypeUiState,
    interaction: CategoryInteraction,
) {
    Column(
        modifier = Modifier
            .padding(
                top = MaterialTheme.dimens.dimens88,
                bottom = MaterialTheme.dimens.dimens70
            )
            .fillMaxWidth()
    ) {
        var selectedCategory by remember { mutableStateOf(MediaType.MOVIE) }
        val pagerState = rememberPagerState(
            initialPage = selectedCategory.ordinal,
        ) {
            if (state.genreMovieList.isNotEmpty()) {
                if (selectedCategory == MediaType.MOVIE) state.genreMovieList.size
                else state.genreTvList.size
            } else {
                0
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.spacing16)
        ) {
            TabRow(
                selectedTabIndex = selectedCategory.ordinal,
                containerColor = MaterialTheme.color.backgroundPrimary,
                indicator = {},
                divider = {}
            ) {
                MediaType.values().forEachIndexed { index, category ->
                    Box {
                        Tab(
                            selected = selectedCategory == category,
                            onClick = {
                                selectedCategory = category
                            },
                            text = {
                                Text(
                                    text = category.name,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    color = Color.White,
                                    style = Typography.headlineSmall
                                )
                            }
                        )
                        this@Column.AnimatedVisibility(
                            visible = selectedCategory == category,
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

            val selectedTabContent: @Composable () -> Unit = {
                when (selectedCategory) {
                    MediaType.MOVIE -> CategoryContent(
                        viewPaperList = state.genreMovieList,
                        interaction,
                        pagerState = pagerState
                    )

                    MediaType.TV -> CategoryContent(
                        viewPaperList = state.genreTvList,
                        interaction,
                        pagerState = pagerState
                    )

                    else -> {}
                }
            }
            selectedTabContent()
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryContent(
    viewPaperList: List<GenreUiState>,
    interaction: CategoryInteraction,
    pagerState: PagerState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
            .padding(top = MaterialTheme.spacing.spacing32)
    ) {
        LazyVerticalGrid(
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
                vertical = MaterialTheme.spacing.spacing64
            ),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.spacing8,
                Alignment.CenterHorizontally
            ),
            verticalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.spacing16,
                Alignment.CenterVertically
            )
        ) {
            items(viewPaperList.size) {
                CategoryItem(
                    media = viewPaperList[it].name,
                    genreId = viewPaperList[it].id.toInt(),
                    modifier = Modifier
                        .clickable {
                            interaction.onClickCard(viewPaperList[it].id, viewPaperList[it].name)
                        }
                )
            }
        }
    }
}




