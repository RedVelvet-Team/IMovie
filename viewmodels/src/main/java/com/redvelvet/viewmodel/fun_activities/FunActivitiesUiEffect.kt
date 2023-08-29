package com.redvelvet.viewmodel.fun_activities

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed class FunActivitiesUiEffect : BaseUiEffect {
    data object NavigateToCinemaRoom : FunActivitiesUiEffect()
    data object NavigateToGuessMovieGame : FunActivitiesUiEffect()
    data object NavigateToGuessActorGame : FunActivitiesUiEffect()
    data object NavigateToGuessTvShowGame : FunActivitiesUiEffect()
    data object NavigateToComingSoon : FunActivitiesUiEffect()

}