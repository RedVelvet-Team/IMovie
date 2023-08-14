package com.redvelvet.viewmodel.seeall.movie

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface SeeAllMovieUiEffect: BaseUiEffect{
    data object MovieDetails: SeeAllMovieUiEffect
}