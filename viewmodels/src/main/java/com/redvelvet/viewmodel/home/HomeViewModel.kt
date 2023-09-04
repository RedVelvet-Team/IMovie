package com.redvelvet.viewmodel.home

import com.redvelvet.entities.movie.Movie
import com.redvelvet.entities.tv.TvShow
import com.redvelvet.usecase.usecase.GetTvShowsCategoriesUseCase
import com.redvelvet.usecase.usecase.movie.GetMoviesCategories
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import com.redvelvet.viewmodel.seeall.tv.toTvShowUiState
import com.redvelvet.viewmodel.utils.MediaType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesCategories: GetMoviesCategories,
    private val getSeriesCategories: GetTvShowsCategoriesUseCase
) : BaseViewModel<HomeUiState, HomeUiEffect>(HomeUiState()),
    HomeInteraction {

    init {
        getMovies()
        getTv()
    }

    private fun getMovies() {
        _state.update {
            it.copy(
                isLoading = false,
                isError = null
            )
        }
        tryToExecute(
            execute = { getMoviesCategories() },
            onSuccessWithData = ::onSuccessMovies,
            onError = ::onError,
        )
    }

    private fun getTv() {
        _state.update {
            it.copy(
                isLoading = false,
                isError = null
            )
        }
        tryToExecute(
            execute = { getSeriesCategories() },
            onSuccessWithData = ::onSuccesTv,
            onError = ::onError,
        )
    }


    private fun onSuccessMovies(movies: List<List<Movie>>) {
        _state.update {
            it.copy(
                isLoading = false,
                movieCategories = listOf(
                    ItemsUiState(
                        title = POPULAR_MOVIES_TITLE,
                        items = movies[0].map { it.toItemUiState() },
                        hasMore = true
                    ),
                    ItemsUiState(
                        title = NOW_PLAYING_TITLE,
                        items = movies[1].map { it.toItemUiState() },
                        hasMore = true
                    ),
                    ItemsUiState(
                        title = UPCOMING_TITLE,
                        items = movies[2].map { it.toItemUiState() },
                        hasMore = true
                    ),
                    ItemsUiState(
                        title = TOP_RATED_TITLE,
                        items = movies[3].map { it.toItemUiState() },
                        hasMore = true
                    ),
                )
            )
        }
    }
    private fun onSuccesTv(movies: List<List<TvShow>>) {
        _state.update {
            it.copy(
                isLoading = false,
                tvShowCategories = listOf(
                    ItemsUiState(
                        title = POPULAR_SERIES_TITLE,
                        items = movies[0].map { it.toTvShowUiState() },
                        hasMore = true
                    ),
                    ItemsUiState(
                        title = AIRING_TODAY_TITLE,
                        items = movies[1].map { it.toTvShowUiState() },
                        hasMore = true
                    ),
                    ItemsUiState(
                        title = ON_TV_TITLE,
                        items = movies[2].map { it.toTvShowUiState() },
                        hasMore = true
                    ),
                    ItemsUiState(
                        title = TOP_RATED_TITLE,
                        items = movies[3].map { it.toTvShowUiState() },
                        hasMore = true
                    ),
                )
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

    companion object {
        private const val POPULAR_MOVIES_TITLE = "Popular Movies"
        private const val NOW_PLAYING_TITLE = "Now Playing"
        private const val UPCOMING_TITLE = "Upcoming"
        private const val TOP_RATED_TITLE = "Top Rated"
        private const val POPULAR_SERIES_TITLE = "Popular Series"
        private const val AIRING_TODAY_TITLE = "Airing Today"
        private const val ON_TV_TITLE = "On TV"
    }

    override fun onChangeCategoryTab(mediaType: MediaType) {
        _state.update {
            it.copy(
                type = mediaType
            )
        }
    }

    override fun onCLickRefresh() {
        getMovies()
        getTv()
    }
}