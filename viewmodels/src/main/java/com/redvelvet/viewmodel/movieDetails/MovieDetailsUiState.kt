package com.redvelvet.viewmodel.movieDetails

import com.redvelvet.entities.movie.details.MovieFullDetails

data class MovieDetailsUiState(
    val data:List<MovieFullDetails> = emptyList(),
    val isLoading: Boolean = true,
    val isError:Pair<Boolean,String> = Pair(false,"")
)





