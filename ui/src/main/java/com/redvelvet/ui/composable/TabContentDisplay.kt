package com.redvelvet.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.redvelvet.ui.theme.dimens
import com.redvelvet.viewmodel.home.ItemUiState
import com.redvelvet.viewmodel.home.ItemsUiState
import com.redvelvet.viewmodel.utils.MediaType
import com.redvelvet.viewmodel.utils.SeeAllMovie
import com.redvelvet.viewmodel.utils.SeeAllTvShows

@Composable
fun TabContentDisplay(
    viewpagerList: List<ItemUiState>,
    categories: List<ItemsUiState>,
    label: String,
    hasName: Boolean = false,
    hasDateAndCountry: Boolean = false,
    onClickSeeAllMovie: (SeeAllMovie) -> Unit = {},
    onClickItem: (String) -> Unit,
    type: MediaType,
    onClickSeeAllTv: (SeeAllTvShows) -> Unit = {}
) {
    val homeSeeAllMovie = listOf(SeeAllMovie.NOW_PLAYING, SeeAllMovie.UPCOMING, SeeAllMovie.TOP_RATED)
    val homeSeeAllTv = listOf(SeeAllTvShows.AIRING_TODAY, SeeAllTvShows.ON_TV, SeeAllTvShows.TOP_RATED)
    LazyColumn(
        contentPadding = PaddingValues(vertical = MaterialTheme.dimens.dimens16),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.dimens24)
    ) {
        item {
            HomeViewPager(
                onClickSeeAllMovie = onClickSeeAllMovie,
                onClickSeeAllTv = onClickSeeAllTv,
                type = type,
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
                onClickSeeAllMovie = onClickSeeAllMovie,
                onClickSeeAllTv = onClickSeeAllTv,
                type = type,
                seeAllMovie = homeSeeAllMovie[index],
                seeAllTv = homeSeeAllTv[index],
                onClickItem = onClickItem
            )
        }
    }
}