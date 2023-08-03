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
            images = MovieDetailsScreenUiState.MovieImagesUiState(
                image = "test"
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
            recommendations = MovieDetailsScreenUiState.MovieRecommendationsUiState(
                test = "test"
            ),
            reviews = MovieDetailsScreenUiState.MovieReviewsUiState(
                test = "test"
            ),
            similar = MovieDetailsScreenUiState.MovieSimilarUiState(
                test = "test"
            ),
        )
    }
}