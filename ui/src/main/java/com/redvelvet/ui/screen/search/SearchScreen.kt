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
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.MessageView
import com.redvelvet.ui.composable.PrimaryTextField
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
        PrimaryTextField(
            onTextChange = onChangeQuery,
            value = state.inputText,
            placeHolderText = "What do you want to Watch?",
            leadingIcon = painterResource(id = R.drawable.icon_search),
            trailingIcon = painterResource(id = R.drawable.icon_cancel),
            modifier = Modifier.padding(
                top = MaterialTheme.dimens.dimens36,
                start = MaterialTheme.spacing.spacing16,
                end = MaterialTheme.spacing.spacing16
            )
        )
        MessageView(
            messageIcon = painterResource(id = R.drawable.vector_serach),
            messageTitle = "Search in Movie",
            messageDescription = "Search for your favorite movies and TV shows that you love.",
        )

//        CategoriesChips(
//            onChangeCategory,
//            state.selectedMediaType,
//            state.getCategories,
//            title = "Categories"
//        )
//
//        CustomLazyGrid(searchCardUiStates = state.searchResult.collectAsLazyPagingItems())
    }
}