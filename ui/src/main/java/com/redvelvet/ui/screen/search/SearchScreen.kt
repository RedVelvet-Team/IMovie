package com.redvelvet.ui.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.composable.InitialContentInSearch
import com.redvelvet.ui.composable.SearchBox
import com.redvelvet.ui.screen.seeAllUpcoming.SeeAllUpcomingListScreen
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Spacing
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.search.SearchUiState
import com.redvelvet.viewmodel.search.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Primary, darkIcons = false)

    val state by viewModel.state.collectAsState()
    SearchContent(state,onChangeQuery =  viewModel::onChangeSearchTextFiled)
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun SearchContent(state: SearchUiState, onChangeQuery: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)
            .padding(MaterialTheme.dimens.dimens16)
    ) {
        SearchBox(query = state.inputText?: "", onChangeQuery = onChangeQuery)
        CategoryChips()

    }
}

@Composable
fun CategoryChips() {
    Text(
        modifier = Modifier.padding(vertical = MaterialTheme.spacing.spacing16),
        text = "Categories",
        style = Typography.bodyMedium,
        color = FontSecondary
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = MaterialTheme.spacing.spacing24),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CategoryChip(text = "All")
        CategoryChip(text = "Movie")
        CategoryChip(text = "Person")
        CategoryChip(text = "Tv Show")
    }
}

@Composable
fun CategoryChip(text: String) {
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .background(Secondary)
            .padding(
                vertical = MaterialTheme.spacing.spacing8,
                horizontal = MaterialTheme.spacing.spacing16
            ),
        text = text,
        style = Typography.bodyMedium,
        color = FontSecondary
    )
}


