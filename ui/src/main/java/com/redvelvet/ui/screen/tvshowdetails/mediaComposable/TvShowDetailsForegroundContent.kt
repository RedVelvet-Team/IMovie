package com.redvelvet.ui.screen.tvshowdetails.mediaComposable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.tvshow.SeriesDetailsUiState
import com.redvelvet.viewmodel.tvshow.TvShowDetailsInteraction

@Composable
fun TvShowDetailsForegroundContent(
    state: SeriesDetailsUiState,
    interaction: TvShowDetailsInteraction,
    onScroll: (offset: Int) -> Unit
) {
    val scrollState = rememberScrollState()
    LaunchedEffect(scrollState.value) {
        onScroll(scrollState.value)
    }
    Column(
        modifier = Modifier
            .padding(top = 48.dp)
            .fillMaxSize()
            .zIndex(1f)
            .verticalScroll(scrollState)
    ) {
        val roundedCorners = if (scrollState.value > 1000) 0.dp else MaterialTheme.radius.radius32
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.spacing285)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = roundedCorners,
                        topEnd = roundedCorners,
                    )
                )
                .fillMaxSize()
                .background(color = Primary)
                .padding(top = MaterialTheme.spacing.spacing24),
        ) {
            TvShowDetailsInfoSection(state, interaction)
            TvShowTopCastSection(state.topCast, interaction)
            TvshowsKeyWordsSection(state.keywords, interaction)
            // TODO: ADD SEASIONS LIST
//            TvShowSeasonsSection(state.seasons, interaction)
            TvShowImagesSection(state.posters, interaction)
            TvShowReviewsSection(state.reviews, interaction)
            RecommendedTvshowSection(state.recommendations, interaction)
        }
    }
}