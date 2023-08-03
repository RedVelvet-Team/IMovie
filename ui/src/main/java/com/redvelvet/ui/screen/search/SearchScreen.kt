package com.redvelvet.ui.screen.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.R
import com.redvelvet.ui.composable.InitialContentInSearch
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.SearchBox
import com.redvelvet.ui.composable.StatusImage
import com.redvelvet.ui.composable.StatusText
import com.redvelvet.ui.theme.FontSecondary
import com.redvelvet.ui.theme.Primary
import com.redvelvet.ui.theme.Purple100
import com.redvelvet.ui.theme.Secondary
import com.redvelvet.ui.theme.Typography
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.radius
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.search.MediaUiState
import com.redvelvet.viewmodel.search.SearchUiState
import com.redvelvet.viewmodel.search.SearchViewModel
import java.util.function.BooleanSupplier

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
    )


}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun SearchContent(
    state: SearchUiState,
    onChangeQuery: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)
            .padding(MaterialTheme.dimens.dimens16)
    ) {
        SearchBox(query = state.inputText ?: "", onChangeQuery = onChangeQuery)
        if (!state.isEmpty) {
            CategoryChips()
            CustomLazyVerticalGrid(mediaUiStates = state.searchResult)
        }else{
            InitialContentInSearch()
        }
            if(state.searchResult.isEmpty()){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            StatusImage(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.vector_not_found),
                contentDescription = stringResource(R.string.no_search_results)
            )
            Spacer( modifier = Modifier.height(MaterialTheme.spacing.spacing32))
            StatusText(
                statusTitle = stringResource(R.string.not_found),
                statusDescription = stringResource(R.string.no_results)
            )
        }
    }
    }
}

@Composable
fun CategoryChips(
) {
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
        CategoryChip(text = "All", isSelected = true) {  }
        CategoryChip(text = "Movie", isSelected = false) { }
        CategoryChip(text = "Person", isSelected = false) {  }
        CategoryChip(text = "Tv Show", isSelected = false) {  }
    }
}

@Composable
fun CategoryChip(text: String, isSelected: Boolean, onClickChip: () -> Unit) {
    Text(
        modifier = Modifier
            .clip(RoundedCornerShape(MaterialTheme.radius.radius8))
            .background(color = if (isSelected) Purple100 else Secondary)
            .padding(
                vertical = MaterialTheme.spacing.spacing8,
                horizontal = MaterialTheme.spacing.spacing16
            )
            .clickable { onClickChip() },
        text = text,
        style = Typography.bodyMedium,
        color = FontSecondary,
        )
}

@Composable
fun CustomLazyVerticalGrid(
    modifier: Modifier = Modifier,
    mediaUiStates: List<MediaUiState>
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Primary)) {
        LazyVerticalGrid(
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
                vertical = MaterialTheme.spacing.spacing24
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
                val BASE_URL = "https://image.tmdb.org/t/p/w500"
                Log.d("banan", mediaUiState.mediaName)
                ItemBasicCard(
                    image = BASE_URL + mediaUiState.mediaImage,
                    hasName = true,
                    name = mediaUiState.mediaName,
                    hasDateAndCountry = mediaUiState.mediaReleaseDate.isNotEmpty(),
                    date = mediaUiState.mediaReleaseDate,
                    country = mediaUiState.mediaCountry
                )
            }
        }
    }
}



