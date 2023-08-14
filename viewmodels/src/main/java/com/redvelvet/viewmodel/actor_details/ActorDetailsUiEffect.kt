package com.redvelvet.viewmodel.actor_details

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface ActorDetailsUiEffect: BaseUiEffect{
    data object NavigateToSeeAllKnowFor: ActorDetailsUiEffect
    data object NavigateToItemDetails: ActorDetailsUiEffect
}