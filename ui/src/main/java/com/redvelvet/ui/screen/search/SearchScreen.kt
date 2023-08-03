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
import com.redvelvet.viewmodel.search.CategoryUiState
import com.redvelvet.viewmodel.search.SearchCardUiState
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
        onChangeQuery = viewModel::onChangeSearchTextFiled,
        onChangeCategory = viewModel::onChangeCategory,
        state = state
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun SearchContent(
    onChangeQuery: (String) -> Unit,
    onChangeCategory: KFunction1<SearchMedia, Unit>,
    state: SearchUiState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
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
        CategoryChips(onChangeCategory, state.selectedMediaType, state.getCategories())
        if (state.searchResult.isNotEmpty()) {
            CustomLazyVerticalGrid(searchCardUiStates = state.searchResult)
        } else {
            InitialContentInSearch()
        }
    }
}

@Composable
fun CategoryChips(
    onChangeCategory: (SearchMedia) -> Unit,
    selectedType: SearchMedia,
    categories: List<CategoryUiState>
) {
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
            horizontal = MaterialTheme.spacing.spacing16,
            vertical = MaterialTheme.spacing.spacing8,
        ),
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing8),
    ) {
        items(categories.size) {
            val category = categories[it]
            CategoryChip(
                onChangeCategory,
                text = category.text,
                type = category.type,
                selectedType = selectedType
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
    searchCardUiStates: List<SearchCardUiState>
) {
    LazyVerticalGrid(
        contentPadding = PaddingValues(
            top = MaterialTheme.spacing.spacing16,
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
        items(searchCardUiStates.size) {
            val mediaUiState = searchCardUiStates[it]
            ItemBasicCard(
                image = mediaUiState.getFullImage(),
                hasName = true,
                name = mediaUiState.name,
                hasDateAndCountry = !mediaUiState.isPerson(),
                date = mediaUiState.releaseDate,
                country = mediaUiState.country
            )
        }
    }
}