package com.redvelvet.ui.screen.categorySeeAll

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.composable.FlixMovieScaffold
import com.redvelvet.ui.composable.ItemBasicCard
import com.redvelvet.ui.composable.LoadingPage
import com.redvelvet.ui.composable.NavigationHandler
import com.redvelvet.ui.composable.rememberAsyncFlixImage
import com.redvelvet.ui.screen.movieDetails.navigateToMovieDetails
import com.redvelvet.ui.theme.color
import com.redvelvet.ui.theme.dimens
import com.redvelvet.ui.theme.spacing
import com.redvelvet.viewmodel.seeall.category.MediaUiState
import com.redvelvet.viewmodel.seeall.category.SeeAllCategoriesInteraction
import com.redvelvet.viewmodel.seeall.category.SeeAllCategoriesUiEffect
import com.redvelvet.viewmodel.seeall.category.SeeAllMediaViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeeAllCategoryScreen(
    viewModel: SeeAllMediaViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.backgroundPrimary, darkIcons = false)
    NavigationHandler(
        effects = viewModel.effect,
        handleEffect = { effect, navController ->
            when (effect) {
                is SeeAllCategoriesUiEffect.NavigateUp -> {
                    navController.popBackStack()
                }

                is SeeAllCategoriesUiEffect.NavigateToDetailsScreen -> {
                    navController.navigateToMovieDetails(effect.id)
                }
            }
        }
    )
    FlixMovieScaffold(
        title = state.title,
        isLoading = state.isLoading,
        error = state.error,
    ) {
        SeeAllCategoryContent(
            category = state.media.collectAsLazyPagingItems(),
            interaction = viewModel
        )
    }
}

@Composable
private fun SeeAllCategoryContent(
    category: LazyPagingItems<MediaUiState>,
    interaction: SeeAllCategoriesInteraction,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.color.backgroundPrimary)
            .padding(top = MaterialTheme.spacing.spacing32)
    ) {
        LazyVerticalGrid(
            contentPadding = PaddingValues(
                horizontal = MaterialTheme.spacing.spacing16,
                vertical = MaterialTheme.spacing.spacing64
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
            items(category.itemCount) {
                ItemBasicCard(
                    imagePainter = rememberAsyncFlixImage(image = category[it]!!.imageUrl),
                    hasName = true,
                    name = category[it]!!.name,
                    hasDateAndCountry = true,
                    date = category[it]!!.date,
                    country = category[it]!!.country,
                    modifier = Modifier
                        .height(MaterialTheme.dimens.dimens176)
                        .width(MaterialTheme.dimens.dimens104)
                        .clickable { interaction.onClickCard(category[it]!!.id) },
                )
            }
            if (category.loadState.append is LoadState.Loading) {
                item(
                    span = { GridItemSpan(3) }
                ) {
                    LoadingPage(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(42.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                    )
                }
            }
        }
    }
}