package com.redvelvet.viewmodel.movieDetails

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.redvelvet.entities.error.ErrorType
import com.redvelvet.usecase.usecase.movie.GetMovieFullDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieFullDetailsUseCase: GetMovieFullDetailsUseCase
) : BaseViewModel<MovieDetailsScreenUiState, MovieDetailsUiEvent>(MovieDetailsScreenUiState()),
    MovieDetailsInteraction {
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
//                        data = getMovieFullDetailsUseCase(298618).toMovieFullDetailsScreenUiState(),
//                        isLoading = false
//                    )
//                }
                Log.w("HASSANWASFY", _state.value.data.toString())
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
                    mediaName = "test 2 dvpdoxvj sdfpovjsdfiovkds ",
                    mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                ),
                MovieDetailsScreenUiState.MovieSimilarUiState(
                    mediaId = 3,
                    mediaName = "test 3 dvpdoxvj sdfpovjsdfiovkds ",
                    mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                ),
                MovieDetailsScreenUiState.MovieSimilarUiState(
                    mediaId = 4,
                    mediaName = "test 4 dvpdoxvj sdfpovjsdfiovkds ",
                    mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                ),
                MovieDetailsScreenUiState.MovieSimilarUiState(
                    mediaId = 5,
                    mediaName = "test 5 dvpdoxvj sdfpovjsdfiovkds ",
                    mediaImage = "https://image.tmdb.org/t/p/w500/6mMczfjM8CiS1WuBOgo5Xom1TcR.jpg",
                ),
            ),
        )
    }

    override fun onClickBack() {

    }

    override fun onClickFavorite(movieId: Int, mediaType: String) {

    }

    override fun onClickSave(movieId: Int) {

    }

    override fun onClickPlayTrailer(movieUrl: String) {

    }

    override fun onClickGenre(genre: String) {

    }

    override fun onClickRateMovie(movieId: Int, rate: Double) {

    }

    override fun onClickTopCastSeeAll() {

    }

    override fun onClickCast(castId: Int) {

    }

    override fun onClickKeyword(keywordId: Int) {

    }

    override fun onClickSimilarMoviesSeeAll() {

    }

    override fun onClickMovie(movieId: Int) {

    }

    override fun onClickMovieImagesSeeAll() {

    }

    override fun onClickPreviewImage(movieImageId: Int) {

    }

    override fun onClickReviewsSeeAll() {

    }

    override fun onClickReview(reviewId: Int) {

    }

    override fun onClickRecommendationsMoviesSeeAll() {

    }
}