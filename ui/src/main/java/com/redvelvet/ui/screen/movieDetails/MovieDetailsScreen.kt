package com.redvelvet.ui.screen.movieDetails

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.redvelvet.ui.composable.CustomMediaDetailsTopAppBar
import com.redvelvet.ui.movieDetails.MovieDetailsUiEvent
import com.redvelvet.ui.screen.movieDetails.mediaComposable.MediaDetailsBackgroundContent
import com.redvelvet.ui.screen.movieDetails.mediaComposable.MediaDetailsForegroundContent
import com.redvelvet.viewmodel.movieDetails.MovieDetailsViewModel

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewMovieDetailsScreen() {
    val uiEvent: MovieDetailsUiEvent? = null
    MovieDetailsScreen(rememberNavController(), uiEvent!!)
}


@Composable
fun MovieDetailsScreen(
    navController: NavController,
    uiEvent: MovieDetailsUiEvent,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MediaDetailsBackgroundContent(
            state.movieDetails?.movieImage ?: "",
            uiEvent,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f)
                .verticalScroll(rememberScrollState())
        ) {
            MediaDetailsForegroundContent(
                state,
                uiEvent
            )
        }
        CustomMediaDetailsTopAppBar(
            uiEvent
        )
    }
}


private fun displayTestToast(context: Context, message: String) {
    Toast.makeText(context, "$message Clicked", Toast.LENGTH_SHORT).show()
}


