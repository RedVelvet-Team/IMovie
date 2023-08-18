package com.redvelvet.ui.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.utils.SeeAllMovie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> TabContentDisplay(
    pagerState: PagerState,
    viewpagerList: List<ItemUiState>,
    label: String,
    categories: List<T>,
    titles: List<String>,
    imagePainters: List<List<Painter>>,
    names: List<List<String>> = emptyList(),
    hasName: Boolean = false,
    hasDateAndCountry: Boolean = false,
    dates: List<List<String>> = emptyList(),
    countries: List<List<String>> = emptyList(),
    onClickSeeAll: (SeeAllMovie) -> Unit = {}
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
                items = viewpagerList
            )
        }
        items(categories.size) { index ->
            ItemsSection(
                label = titles[index],
                imagesPainters = imagePainters[index],
                hasName = hasName,
                hasDateAndCountry = hasDateAndCountry,
                names = names[index],
                dates = dates[index],
                countries = countries[index],
                onClickSeeAll = onClickSeeAll,
                seeAllMovie = homeSeeAll[index]
            )
        }
    }
}