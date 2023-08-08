package com.redvelvet.ui.composable

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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.HomeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilxTabLayout(
    viewModel: HomeViewModel = HomeViewModel(),
    pagerState: PagerState
) {
    val state by viewModel.state.collectAsState()
    FilxTabLayoutContent(state.tabLayoutTitles, pagerState = pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FilxTabLayoutContent(
    titles: List<String>,
    pagerState: PagerState
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.spacing.spacing16)
    ) {
        val scope = rememberCoroutineScope()
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            containerColor = MaterialTheme.color.backgroundPrimary,
            indicator = {
            },
            divider = {}
        ) {
            titles.forEachIndexed { index, title ->
                Box {
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
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
                    if (pagerState.currentPage == index) {
                        Box(
                            Modifier
                                .fillMaxWidth(0.6f)
                                .height(MaterialTheme.dimens.dimens4)
                                .align(Alignment.BottomCenter)
                                .background(MaterialTheme.color.brand100, RoundedCornerShape(50))
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun previewTabLayout() {
    FilxTabLayout(pagerState = rememberPagerState(pageCount = { 2 }))
}