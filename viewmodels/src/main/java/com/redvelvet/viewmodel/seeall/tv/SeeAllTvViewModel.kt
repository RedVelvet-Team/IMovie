package com.redvelvet.viewmodel.seeall.tv

import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.seeall.movie.SeeAllMovieUiEffect
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeeAllTvViewModel @Inject constructor(

): BaseViewModel<SeeAllTvShowUiState, SeeAllMovieUiEffect>(SeeAllTvShowUiState()){

}