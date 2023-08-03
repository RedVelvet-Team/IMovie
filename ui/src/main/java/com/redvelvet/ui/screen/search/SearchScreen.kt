package com.redvelvet.ui.screen.search

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.composable.InitialContentInSearch
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.SearchBox
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.search.MediaUiState
import com.redvelvet.viewmodel.search.SearchMedia
import com.redvelvet.viewmodel.search.SearchUiState
import com.redvelvet.viewmodel.search.SearchViewModel
import kotlin.reflect.KFunction1

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)

    val state by viewModel.state.collectAsState()
    SearchContent(
        state,
        onChangeQuery = viewModel::onChangeSearchTextFiled,
        onChangeCategory = viewModel::onChangeCategory
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun SearchContent(
    state: SearchUiState,
    onChangeQuery: (String) -> Unit,
    onChangeCategory: KFunction1<SearchMedia, Unit>,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)
    ) {
        SearchBox(
            query = state.inputText,
            onChangeQuery = onChangeQuery,
            modifier = Modifier.padding(
                top = MaterialTheme.dimens.dimens36,
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16
            )
        )
        CategoryChips(state.mediaType, onChangeCategory)
        if (!state.searchResult.isEmpty()) {
            CustomLazyVerticalGrid(mediaUiStates = state.searchResult)
        } else {
            InitialContentInSearch()
        }
    }
}

@Composable
fun CategoryChips(mediaType: SearchMedia, onChangeCategory: (SearchMedia) -> Unit) {
    Text(
        modifier = Modifier.padding(
            top = MaterialTheme.spacing.spacing16,
            start = MaterialTheme.spacing.spacing16
        ),
        text = "Categories",
        style = Typography.displayMedium,
        color = FontSecondary
    )
    LazyRow(
        contentPadding = PaddingValues(
            start = MaterialTheme.spacing.spacing16,
            end = MaterialTheme.spacing.spacing16,
            top = MaterialTheme.spacing.spacing8,
        ),
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
    ) {
        item {
            CategoryChip(
                onClickChip = onChangeCategory,
                text = "All",
                type = SearchMedia.ALL,
                selectedType = mediaType
            )
        }
        item {
            CategoryChip(
                onClickChip = onChangeCategory,
                text = "Movie",
                type = SearchMedia.MOVIE,
                selectedType = mediaType
            )
        }
        item {
            CategoryChip(
                onClickChip = onChangeCategory,
                text = "Person",
                type = SearchMedia.PEOPLE,
                selectedType = mediaType
            )
        }
        item {
            CategoryChip(
                onClickChip = onChangeCategory,
                text = "Tv Show",
                type = SearchMedia.TV,
                selectedType = mediaType
            )
        }
    }

}

@Composable
fun CategoryChip(
    onClickChip: (SearchMedia) -> Unit,
    text: String,
    type: SearchMedia,
    selectedType: SearchMedia,
) {
    val color by animateColorAsState(
        targetValue = if (type == selectedType) Purple100 else Secondary,
        label = ""
    )
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .background(color = color)
            .clickable { onClickChip(type) }
            .padding(
                vertical = MaterialTheme.spacing.spacing8,
                horizontal = MaterialTheme.spacing.spacing16
            ),
        text = text,
        style = Typography.headlineSmall.copy(fontWeight = FontWeight.Normal),
        color = FontSecondary,
    )
}

@Composable
fun CustomLazyVerticalGrid(
    modifier: Modifier = Modifier,
    mediaUiStates: List<MediaUiState>
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(
            top = MaterialTheme.spacing.spacing24,
            bottom = MaterialTheme.spacing.spacing80,
            start = MaterialTheme.spacing.spacing16,
            end = MaterialTheme.spacing.spacing16
        ),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(
            MaterialTheme.spacing.spacing8,
            Alignment.CenterHorizontally
        ),
        verticalArrangement = Arrangement.spacedBy(
            MaterialTheme.spacing.spacing16,
            Alignment.CenterVertically
        )
    ) {
        items(mediaUiStates.size) {
            val mediaUiState = mediaUiStates[it]
            ItemBasicCard(
                image = mediaUiState.getFullImage(),
                hasName = true,
                name = mediaUiState.mediaName,
                hasDateAndCountry = !mediaUiState.isPerson(),
                date = mediaUiState.mediaReleaseDate,
                country = mediaUiState.mediaCountry
            )
        }
    }
}



