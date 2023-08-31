package com.redvelvet.ui.screen.fun_activites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.redvelvet.ui.LocalNavController
import com.redvelvet.ui.screen.game.navigateToGameDetailsScreen
import com.redvelvet.ui.screen.room.navigateToCinemaRoom
import com.redvelvet.ui.util.launchCollectLatest
import com.redvelvet.viewmodel.fun_activities.FunActivitiesUiEffect
import com.redvelvet.viewmodel.fun_activities.FunActivitiesViewModel
import com.redvelvet.viewmodel.utils.MediaType

@Composable
fun FunScreen(
    viewModel: FunActivitiesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val navController = LocalNavController.current
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(Color.Transparent)
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = Unit) {
        scope.launchCollectLatest(viewModel.effect) { effect ->
            when (effect) {
                is FunActivitiesUiEffect.NavigateToCinemaRoom->{
                    navController.navigateToCinemaRoom()
                }
            }
        }
    }
    FunContent(onClickItem = {navController.navigateToGameDetailsScreen(MediaType.MOVIE)})
}

@Composable
fun FunContent(
    onClickItem:()->Unit
) {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        LazyColumn(
           // modifier = Modifier.background(color = MaterialTheme.colorScheme.secondary),
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.spacedBy(8.dp),

        ) {
            items(12) { position ->
                FunItem( onClickItem = onClickItem)
            }
        }

    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewFunScreen() {
    FunScreen()
}