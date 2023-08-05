package com.redvelvet.ui.screen.movieDetails

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
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
import com.redvelvet.ui.composable.LoadingState
import com.redvelvet.ui.screen.movieDetails.mediaComposable.MediaDetailsBackgroundContent
import com.redvelvet.ui.screen.movieDetails.mediaComposable.MediaDetailsForegroundContent
import com.redvelvet.viewmodel.movieDetails.MovieDetailsScreenUiState
import com.redvelvet.viewmodel.movieDetails.MovieDetailsViewModel

@Preview(
    showSystemUi = true,
    showBackground = true,
    device = "spec:orientation=portrait,width=800dp,height=360dp"
)
@Composable
fun PreviewMovieDetailsScreen() {
    val uiEvent: MovieDetailsUiEvent = MovieEventsTest()
    MovieDetailsScreen(rememberNavController(), uiEvent)

}


@Composable
fun MovieDetailsScreen(
    navController: NavController,
    uiEvent: MovieDetailsUiEvent,
//    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
//    val state by viewModel.state.collectAsState()
    val state = MovieDetailsScreenUiState(
        data = fakeData(),
        isLoading = false,
        isError = Pair(false, "")
    )
    if (state.isLoading && !state.isError.first) {
        LoadingState()
    }
    if (!state.isLoading && state.isError.first) {
        Text(
            text = state.isError.second,
            modifier = Modifier
                .fillMaxSize()
        )
    }
    if (!state.isLoading && !state.isError.first) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            MediaDetailsBackgroundContent(
                "${state.data?.details?.posterPath}",
                uiEvent,
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                MediaDetailsForegroundContent(state, uiEvent)
            }
            CustomMediaDetailsTopAppBar(uiEvent)
        }
    }
}

private fun fakeData(): MovieDetailsScreenUiState.MovieFullDetailsUiState {
    return MovieDetailsScreenUiState.MovieFullDetailsUiState(
        details = MovieDetailsScreenUiState.MovieDetailsUiState(
            genres = listOf("Action", "Adventure", "Fantasy", "Action", "Adventure", "Fantasy"),
            homepage = "https://www.starwars.com/films/star-wars-episode-iv-a-new-hope",
            id = 11,
            originalTitle = "Star Wars",
            overview = "Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire. Venturesome Luke Skywalker and dashing captain Han Solo team together with the loveable robot duo R2-D2 and C-3PO to rescue the beautiful princess and restore peace and justice in the Empire.",
            posterPath = "https://image.tmdb.org/t/p/w500/rktDFPbfHfUbArZ6OOOKsXcv0Bm.jpg",
            productionCountries = listOf("United States of America"),
            releaseDate = "1977-05-25",
            revenue = 775398007,
            runtime = "121",
            spokenLanguages = "English, Arabic",
            status = "Released",
            tagline = "A long time ago in a galaxy far, far away...",
            title = "Star Wars",
            video = false,
            voteAverage = 8.2
        ),
        topCast = listOf(
            MovieDetailsScreenUiState.MovieTopCastUiState(
                castId = 1,
                castName = "Halle Bailey",
                castImage = "https://image.tmdb.org/t/p/w500/hLtxNK8eeWZkFSeaAASFWm15Qv0.jpg"
            ),
            MovieDetailsScreenUiState.MovieTopCastUiState(
                castId = 2,
                castName = "JonahHauer-King",
                castImage = "https://image.tmdb.org/t/p/w500/1GOW1cejmE8D8T6PRikYlGmUae0.jpg"
            ),
            MovieDetailsScreenUiState.MovieTopCastUiState(
                castId = 3,
                castName = "Daveed Diggs",
                castImage = "https://image.tmdb.org/t/p/w500/82rxrGxOqQW2NjKsIiNbDYHFfmb.jpg"
            ),
            MovieDetailsScreenUiState.MovieTopCastUiState(
                castId = 4,
                castName = "Awkwafina",
                castImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg"
            ),
            MovieDetailsScreenUiState.MovieTopCastUiState(
                castId = 5,
                castName = "hLtxNK8ee",
                castImage = "https://image.tmdb.org/t/p/w500/1GOW1cejmE8D8T6PRikYlGmUae0.jpg"
            ),
        ),

        images = listOf(
            MovieDetailsScreenUiState.MovieImagesUiState(
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieImagesUiState(
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieImagesUiState(
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieImagesUiState(
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieImagesUiState(
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
        ),

        keyWords = listOf(
            MovieDetailsScreenUiState.MovieKeyWordsUiState(
                keywordId = 1,
                keywordString = "test 1"
            ),
            MovieDetailsScreenUiState.MovieKeyWordsUiState(
                keywordId = 2,
                keywordString = "test 2"
            ),
            MovieDetailsScreenUiState.MovieKeyWordsUiState(
                keywordId = 3,
                keywordString = "test 3"
            ),
            MovieDetailsScreenUiState.MovieKeyWordsUiState(
                keywordId = 4,
                keywordString = "test 4"
            ),
            MovieDetailsScreenUiState.MovieKeyWordsUiState(
                keywordId = 5,
                keywordString = "test 5"
            ),
        ),

        recommendations = listOf(
            MovieDetailsScreenUiState.MovieRecommendationsUiState(
                mediaId = 1,
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                mediaName = "test 1"
            ),
            MovieDetailsScreenUiState.MovieRecommendationsUiState(
                mediaId = 2,
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                mediaName = "test 2"
            ),
            MovieDetailsScreenUiState.MovieRecommendationsUiState(
                mediaId = 3,
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                mediaName = "test 3"
            ),
            MovieDetailsScreenUiState.MovieRecommendationsUiState(
                mediaId = 4,
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                mediaName = "test 4"
            ),
            MovieDetailsScreenUiState.MovieRecommendationsUiState(
                mediaId = 5,
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                mediaName = "test 5"
            ),
        ),

        reviews = listOf(
            MovieDetailsScreenUiState.MovieReviewsUiState(
                reviewId = "1",
                reviewStars = 5.5,
                reviewDescription = "Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire.",
                reviewAuthor = "Taha",
                reviewDate = "2021-05-25",
            ),
            MovieDetailsScreenUiState.MovieReviewsUiState(
                reviewId = "2",
                reviewStars = 5.5,
                reviewDescription = "Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire.",
                reviewAuthor = "Saad",
                reviewDate = "2011-05-25",
            ),
            MovieDetailsScreenUiState.MovieReviewsUiState(
                reviewId = "3",
                reviewStars = 5.5,
                reviewDescription = "Princess Leia is captured and held hostage by the evil Imperial forces in their effort to take over the galactic Empire.",
                reviewAuthor = "SeSe",
                reviewDate = "2018-06-25",
            ),
        ),
        similar = listOf(
            MovieDetailsScreenUiState.MovieSimilarUiState(
                mediaId = 1,
                mediaName = "test 1",
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieSimilarUiState(
                mediaId = 2,
                mediaName = "test 2",
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieSimilarUiState(
                mediaId = 3,
                mediaName = "test 3",
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieSimilarUiState(
                mediaId = 4,
                mediaName = "test 4",
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
            MovieDetailsScreenUiState.MovieSimilarUiState(
                mediaId = 5,
                mediaName = "test 5",
                mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
            ),
        ),
    )
}
