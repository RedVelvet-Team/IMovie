package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(

) : BaseViewModel<MovieDetailsScreenUiState>(MovieDetailsScreenUiState()) {

    init {
        fakeData()
    }

    private fun fakeData() {
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
    }

}