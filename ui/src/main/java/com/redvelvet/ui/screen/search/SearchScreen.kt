package com.redvelvet.ui.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.composable.CategoriesChips
import com.redvelvet.ui.composable.CustomLazyGrid
import com.redvelvet.ui.composable.SearchBox
import com.redvelvet.ui.theme.BackgroundPrimary
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.search.SearchUiState
import com.redvelvet.viewmodel.search.SearchViewModel
import com.redvelvet.viewmodel.utils.SearchMedia
import kotlin.reflect.KFunction1

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(BackgroundPrimary, darkIcons = false)

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
            .background(MaterialTheme.color.backgroundPrimary)
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
        CategoriesChips(
            onChangeCategory,
            state.selectedMediaType,
            state.getCategories,
            title = "Categories"
        )
        CustomLazyGrid(searchCardUiStates = state.searchResult.collectAsLazyPagingItems())
    }
}