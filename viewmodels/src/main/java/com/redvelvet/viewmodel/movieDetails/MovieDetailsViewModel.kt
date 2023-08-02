package com.redvelvet.viewmodel.movieDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.error.ErrorType
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.base.toErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<MovieDetailsUiState> = MutableStateFlow(MovieDetailsUiState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _state.update {
                    MovieDetailsUiState(data = listOf(getMovieFullDetailsUseCase(5585)),isLoading = false)
                }
            } catch (e: ErrorType) {
                _state.update {
                    MovieDetailsUiState(data = emptyList(),isLoading = false, isError = Pair(true,e.message.toString()))
                }
            }
        }
    }

    /*private fun fakeData() {
        _state.update {
            it.copy(
                movieDetails = MovieDetailsScreenUiState.MovieDetailsUiState(
                    movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                    movieName = "Real Madrid",
                    listOfGenres = listOf("Action", "Drama"),
                    movieTime = "2h 30m",
                    languageOfMovie = "English",
                    movieRate = "8.5",
                    movieDescription = "This is a movie about Real Madrid",
                    movieStatus = "Released",
                    movieReleaseDate = "23/8/2001",
                    movieProductionCountries = "Espania",
                ),
                movieTopCasts = listOf(
                    MovieDetailsScreenUiState.TopCastUiState(
                        castImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        castName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.TopCastUiState(
                        castImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        castName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.TopCastUiState(
                        castImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        castName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.TopCastUiState(
                        castImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        castName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.TopCastUiState(
                        castImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        castName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.TopCastUiState(
                        castImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        castName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.TopCastUiState(
                        castImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        castName = "Real Madrid",
                    ),

                    ),
                movieKeywords = listOf(
                    MovieDetailsScreenUiState.KeywordUiState(
                        keywordName = "Real Madrid",
                        keywordId = 1,
                    ),
                    MovieDetailsScreenUiState.KeywordUiState(
                        keywordName = "Real Madrid",
                        keywordId = 1,
                    ),
                    MovieDetailsScreenUiState.KeywordUiState(
                        keywordName = "Real Madrid",
                        keywordId = 1,
                    ),
                    MovieDetailsScreenUiState.KeywordUiState(
                        keywordName = "Real Madrid",
                        keywordId = 1,
                    ),
                    MovieDetailsScreenUiState.KeywordUiState(
                        keywordName = "Real Madrid",
                        keywordId = 1,
                    ),
                    MovieDetailsScreenUiState.KeywordUiState(
                        keywordName = "Real Madrid",
                        keywordId = 1,
                    ),
                    MovieDetailsScreenUiState.KeywordUiState(
                        keywordName = "Real Madrid",
                        keywordId = 1,
                    ),

                    ),
                similarMovies = listOf(
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                ),
                movieImages = listOf(
                    "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                    "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                    "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                    "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                    "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                    "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                    "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                ),
                movieReviews = listOf(
                    MovieDetailsScreenUiState.MovieReviewUiState(
                        reviewAuthor = "Real Madrid",
                        reviewDescription = "Real Madrid",
                        reviewRate = "4.5",
                        reviewDate = "23/8/2001",
                    ),
                    MovieDetailsScreenUiState.MovieReviewUiState(
                        reviewAuthor = "Real Madrid",
                        reviewDescription = "Real Madrid dcpdokk podvd",
                        reviewRate = "4.5",
                        reviewDate = "23/8/2001",
                    ),

                    MovieDetailsScreenUiState.MovieReviewUiState(
                        reviewAuthor = "Real Madrid",
                        reviewDescription = "Real Madrid dcpdokk podvd",
                        reviewRate = "4.5",
                        reviewDate = "23/8/2001",
                    ),
                ),
                recommendedMovies = listOf(
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                    MovieDetailsScreenUiState.MovieUiState(
                        movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                        movieName = "Real Madrid",
                    ),
                ),
            )
        }
    }*/



}