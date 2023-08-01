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
    MovieDetailsScreen(rememberNavController())
}


@Composable
fun MovieDetailsScreen(navController: NavController, viewModel: MovieDetailsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    val context = LocalContext.current
    val onMovieFavorite = {
        displayTestToast(context, "favorite")
    }
    val onMovieSave = {
        displayTestToast(context, "save")
    }
    val onBack = {
        displayTestToast(context, "back")
    }
    val onMoviePlay = {
        displayTestToast(context, "play")
    }
    val onMovieCategory = {
        displayTestToast(context, "category")
    }
    val onDescriptionMore = {
        displayTestToast(context, "more")
    }
    val onTopCastSeeAll = {
        displayTestToast(context, "top cast see all")
    }
    val onCast = {
        displayTestToast(context, "cast")
    }
    val onMovieKeyword = {
        displayTestToast(context, "keyword")
    }
    val onSimilarMovieSeeAll = {
        displayTestToast(context, "similar movie see all")
    }
    val onRecommendedMovieSeeAll = {
        displayTestToast(context, "recommended movie see all")
    }
    val onMovie = {
        displayTestToast(context, "movie")
    }
    val onMovieImagesSeeAll = {
        displayTestToast(context, "movie images see all")
    }
    val onMovieImage = {
        displayTestToast(context, "movie image")
    }
    val onMovieReviewsSeeAll = {
        displayTestToast(context, "movie Reviews see all")
    }
    val onMovieReview = {
        displayTestToast(context, "movie review")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MediaDetailsBackgroundContent(
            state.movieDetails?.movieImage ?: "",
            onMoviePlay,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .zIndex(1f)
                .verticalScroll(rememberScrollState())
        ) {
            MediaDetailsForegroundContent(
                state,
                onMovieCategory,
                onDescriptionMore,
                onTopCastSeeAll,
                onCast,
                onMovieKeyword,
                onSimilarMovieSeeAll,
                onRecommendedMovieSeeAll,
                onMovie,
                onMovieImagesSeeAll,
                onMovieImage,
                onMovieReviewsSeeAll,
                onMovieReview,
            )
        }
        CustomMediaDetailsTopAppBar(
            onBack,
            onMovieFavorite,
            onMovieSave,
        )
    }
}


private fun displayTestToast(context: Context, message: String) {
    Toast.makeText(context, "$message Clicked", Toast.LENGTH_SHORT).show()
}


