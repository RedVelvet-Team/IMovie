package com.redvelvet.viewmodel.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.error.ErrorType
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<MovieDetailsScreenUiState> =
        MutableStateFlow(MovieDetailsScreenUiState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        _state.update { MovieDetailsScreenUiState(isLoading = true, isError = Pair(false, "")) }
        viewModelScope.launch {
        delay(2000)
            try {
//                _state.update {
//                    MovieDetailsScreenUiState(
//                        data = getMovieFullDetailsUseCase(5585).toMovieFullDetailsScreenUiState(),
//                        isLoading = false
//                    )
//                }

                _state.update {
                    MovieDetailsScreenUiState(data = fakeData(), isLoading = false)
                }


            } catch (e: ErrorType) {
                _state.update {
                    MovieDetailsScreenUiState(
                        data = null,
                        isLoading = false,
                        isError = Pair(true, e.message.toString())
                    )
                }
            }
        }
    }

    private fun fakeData(): MovieDetailsScreenUiState.MovieFullDetailsUiState {
        return MovieDetailsScreenUiState.MovieFullDetailsUiState(
            details = MovieDetailsScreenUiState.MovieDetailsUiState(
                genres = listOf("Action", "Adventure", "Fantasy"),
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
            images = MovieDetailsScreenUiState.MovieImagesUiState(
                test = "test"
            ),
            keyWords = MovieDetailsScreenUiState.MovieKeyWordsUiState(
                test = "test"
            ),
            recommendations = MovieDetailsScreenUiState.MovieRecommendationsUiState(
                test = "test"
            ),
            reviews = MovieDetailsScreenUiState.MovieReviewsUiState(
                test = "test"
            ),
            similar = MovieDetailsScreenUiState.MovieSimilarUiState(
                test = "test"
            ),
            topCast = MovieDetailsScreenUiState.MovieTopCastUiState(
                test = "test"
            )
        )
    }
}