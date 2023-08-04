package com.redvelvet.viewmodel.home

import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : BaseViewModel<HomeUiState, Unit>(HomeUiState()) {

    init {
        fakeData()
    }

    private fun fakeData() {
        _state.update {
            it.copy(
                popularMovies = fakeList(),
                nowPlayingMovies = fakeList(),
                upComingMovies = fakeList(),
                topRatedMovies = fakeList(),
            )
        }
    }

    private fun fakeList(): List<MovieUiState> {
        return listOf(
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
            MovieUiState(
                movieImage = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                movieDate = "23/8/2001",
                movieName = "Real Madrid",
                countryOfMovie = "Espania"
            ),
        )
    }

}