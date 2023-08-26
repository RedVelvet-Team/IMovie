package com.redvelvet.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.home.ItemsUiState
import com.redvelvet.viewmodel.utils.SeeAllMovie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabContentDisplay(
    pagerState: PagerState,
    viewpagerList: List<ItemUiState>,
    categories: List<ItemsUiState>,
    label: String,
    hasName: Boolean = false,
    hasDateAndCountry: Boolean = false,
    onClickSeeAll: (SeeAllMovie) -> Unit = {},
    onClickItem: (String) -> Unit
) {
    val homeSeeAll = listOf(SeeAllMovie.NOW_PLAYING, SeeAllMovie.UPCOMING, SeeAllMovie.TOP_RATED)
    LazyColumn(
        contentPadding = PaddingValues(vertical = MaterialTheme.spacing.spacing16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing24)
    ) {
        item {
            HomeViewPager(
                state = pagerState,
                onClickSeeAll = onClickSeeAll,
                label = label,
                items = viewpagerList,
                onClickItem = onClickItem
            )
        }
        items(3) { index ->
            ItemsSection(
                items = if (categories.isNotEmpty()) categories[index + 1] else ItemsUiState(),
                hasName = hasName,
                hasDateAndCountry = hasDateAndCountry,
                onClickSeeAll = onClickSeeAll,
                seeAllMovie = homeSeeAll[index],
                onClickItem = onClickItem
            )
        }
    }
}