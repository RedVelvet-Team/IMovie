package com.redvelvet.ui.screen.category

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.category.GenreUiState
import com.redvelvet.viewmodel.category.MediaTypeUiState

@Composable
fun CategoryScreen() {
    FlixMovieScaffold(
        title = "Category",
        isLoading = false,
        hasTopBar = true,
        hasBackArrow = false
    ) {
        CategoryContent(state = MediaTypeUiState())
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryContent(
    state: MediaTypeUiState,
) {
    Column(
        modifier = Modifier
            .padding(
                top = MaterialTheme.dimens.dimens88,
                bottom = MaterialTheme.dimens.dimens70
            )
            .fillMaxWidth()
    ) {
        var page by remember { mutableIntStateOf(0) }
        val pagerState = rememberPagerState(initialPage = 0) {
            if (page == 0) state.genreList.size
            else state.genreList.size
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
                state.type.forEachIndexed { index, title ->
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
            val selectedTabContent: @Composable () -> Unit = when (page) {
                0 -> {
                    {

                    }
                }

                1 -> {
                    {
                        //TODO
                    }
                }

                else -> {
                    {}
                }
            }
            selectedTabContent()
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieCategoryContent(
    state: MediaTypeUiState,
    pagerState: PagerState,
    viewPaperList: List<GenreUiState>
) {
    val navController = LocalNavController.current


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TvShowCategoryContent(
    state: MediaTypeUiState,
    pagerState: PagerState,
    viewPaperList: List<GenreUiState>
) {
    val navController = LocalNavController.current

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabCategoryDisplay(
    pagerState: PagerState,
    viewPaperList: List<GenreUiState>,
    category: List<GenreUiState>,
    onClickItem: (String) -> Unit
) {
//    LazyRow(
//        contentPadding = PaddingValues(vertical = MaterialTheme.spacing.spacing16),
//        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing24)
//    ) {}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
            .padding(top = MaterialTheme.spacing.spacing32)
    ){
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
        ){

        }
    }

}
