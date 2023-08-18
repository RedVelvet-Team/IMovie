package com.redvelvet.viewmodel.home

import com.redvelvet.entities.movie.details.MovieDetails
import com.redvelvet.usecase.usecase.movie.GetMoviesCategories
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesCategories: GetMoviesCategories,
) : BaseViewModel<HomeUiState, Unit>(HomeUiState()) {

    init {
        fakeData()
    }

    private fun getPopularMovies() {
        _state.update {
            it.copy(
                isLoading = true,
                isError = null
            )
        }
        tryToExecute(
            execute = {getMoviesCategories()},
            onSuccessWithData = ::onSuccessMovies,
            onError = ::onError,
        )
    }

    private fun onSuccessMovies(movies: List<List<MovieDetails>>) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = null,
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = error,
            )
        }
    }


    private fun fakeData() {
        _state.update {
            it.copy(
                movieCategories = fakeMoviesCategories(),
                tvShowCategories = fakeTvShowCategories(),
                tabLayoutTitles = listOf("Movies", "TV Shows"),
            )
        }
    }

    private fun fakeMoviesCategories() =
        listOf(
            fakeMovieCategory("Now Playing"),
            fakeMovieCategory("Upcoming"),
            fakeMovieCategory("Top Rated"),
        )

    private fun fakeTvShowCategories() =
        listOf(
            fakeTvShowCategory("Airing Today"),
            fakeTvShowCategory("On TV"),
            fakeTvShowCategory("Top Rated"),
        )

    private fun fakeMovieCategory(title: String) =
        ItemsUiState(
            title = title,
            items = fakeMoviesList()
        )

    private fun fakeTvShowCategory(title: String) =
        ItemsUiState(
            title = title,
            items = fakeTvShowList()
        )

    private fun fakeMoviesList(): List<ItemUiState> {
        return listOf(
            ItemUiState(
                image = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                date = "23/8/2001",
                name = "Real Madrid",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://th.bing.com/th/id/R.288a9cdbf8a965fba8a044e1aac9f2eb?rik=DBP9DF9RfFfb%2fw&riu=http%3a%2f%2fwww.barcelonaconnect.com%2fwp-content%2fuploads%2f2016%2f02%2f1389120212768861.jpg&ehk=r3LRNPFmRnje0DlkhtyOzcrbJ%2fRgrAjS1J882gOJj6U%3d&risl=&pid=ImgRaw&r=0",
                date = "23/8/2001",
                name = "Barcelona",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                date = "23/8/2001",
                name = "Real Madrid",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://th.bing.com/th/id/R.288a9cdbf8a965fba8a044e1aac9f2eb?rik=DBP9DF9RfFfb%2fw&riu=http%3a%2f%2fwww.barcelonaconnect.com%2fwp-content%2fuploads%2f2016%2f02%2f1389120212768861.jpg&ehk=r3LRNPFmRnje0DlkhtyOzcrbJ%2fRgrAjS1J882gOJj6U%3d&risl=&pid=ImgRaw&r=0",
                date = "23/8/2001",
                name = "Barcelona",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                date = "23/8/2001",
                name = "Real Madrid",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://th.bing.com/th/id/R.288a9cdbf8a965fba8a044e1aac9f2eb?rik=DBP9DF9RfFfb%2fw&riu=http%3a%2f%2fwww.barcelonaconnect.com%2fwp-content%2fuploads%2f2016%2f02%2f1389120212768861.jpg&ehk=r3LRNPFmRnje0DlkhtyOzcrbJ%2fRgrAjS1J882gOJj6U%3d&risl=&pid=ImgRaw&r=0",
                date = "23/8/2001",
                name = "Barcelona",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                date = "23/8/2001",
                name = "Real Madrid",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://th.bing.com/th/id/R.288a9cdbf8a965fba8a044e1aac9f2eb?rik=DBP9DF9RfFfb%2fw&riu=http%3a%2f%2fwww.barcelonaconnect.com%2fwp-content%2fuploads%2f2016%2f02%2f1389120212768861.jpg&ehk=r3LRNPFmRnje0DlkhtyOzcrbJ%2fRgrAjS1J882gOJj6U%3d&risl=&pid=ImgRaw&r=0",
                date = "23/8/2001",
                name = "Barcelona",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://www.realmadrid.com/StaticFiles/RealMadridResponsive/images/static/twitter-image.png",
                date = "23/8/2001",
                name = "Real Madrid",
                country = "Espania"
            ),
            ItemUiState(
                image = "https://th.bing.com/th/id/R.288a9cdbf8a965fba8a044e1aac9f2eb?rik=DBP9DF9RfFfb%2fw&riu=http%3a%2f%2fwww.barcelonaconnect.com%2fwp-content%2fuploads%2f2016%2f02%2f1389120212768861.jpg&ehk=r3LRNPFmRnje0DlkhtyOzcrbJ%2fRgrAjS1J882gOJj6U%3d&risl=&pid=ImgRaw&r=0",
                date = "23/8/2001",
                name = "Barcelona",
                country = "Espania"
            ),
        )
    }

    private fun fakeTvShowList() =
        listOf(
            ItemUiState(
                image = "https://cdn1.edgedatg.com/aws/v2/abc/TheGoodDoctor/showimages/d970024e1e411bee6f4fef77b3ee6040/1200x627-Q80_d970024e1e411bee6f4fef77b3ee6040.jpg",
                date = "25/9/2017",
                name = "The good doctor",
                country = "Us"
            ),
            ItemUiState(
                image = "https://cdn1.edgedatg.com/aws/v2/abc/TheGoodDoctor/showimages/d970024e1e411bee6f4fef77b3ee6040/1200x627-Q80_d970024e1e411bee6f4fef77b3ee6040.jpg",
                date = "25/9/2017",
                name = "The good doctor",
                country = "Us"
            ),
            ItemUiState(
                image = "https://cdn1.edgedatg.com/aws/v2/abc/TheGoodDoctor/showimages/d970024e1e411bee6f4fef77b3ee6040/1200x627-Q80_d970024e1e411bee6f4fef77b3ee6040.jpg",
                date = "25/9/2017",
                name = "The good doctor",
                country = "Us"
            ),
            ItemUiState(
                image = "https://cdn1.edgedatg.com/aws/v2/abc/TheGoodDoctor/showimages/d970024e1e411bee6f4fef77b3ee6040/1200x627-Q80_d970024e1e411bee6f4fef77b3ee6040.jpg",
                date = "25/9/2017",
                name = "The good doctor",
                country = "Us"
            ), ItemUiState(
                image = "https://cdn1.edgedatg.com/aws/v2/abc/TheGoodDoctor/showimages/d970024e1e411bee6f4fef77b3ee6040/1200x627-Q80_d970024e1e411bee6f4fef77b3ee6040.jpg",
                date = "25/9/2017",
                name = "The good doctor",
                country = "Us"
            ),
            ItemUiState(
                image = "https://cdn1.edgedatg.com/aws/v2/abc/TheGoodDoctor/showimages/d970024e1e411bee6f4fef77b3ee6040/1200x627-Q80_d970024e1e411bee6f4fef77b3ee6040.jpg",
                date = "25/9/2017",
                name = "The good doctor",
                country = "Us"
            ),
            ItemUiState(
                image = "https://cdn1.edgedatg.com/aws/v2/abc/TheGoodDoctor/showimages/d970024e1e411bee6f4fef77b3ee6040/1200x627-Q80_d970024e1e411bee6f4fef77b3ee6040.jpg",
                date = "25/9/2017",
                name = "The good doctor",
                country = "Us"
            )
        )
}