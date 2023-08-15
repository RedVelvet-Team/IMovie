package com.redvelvet.viewmodel.knownFor

import com.redvelvet.viewmodel.base.BaseUiEffect

sealed interface ActorWorksUiEffect: BaseUiEffect{
    data object NavigateToItemDetails: ActorWorksUiEffect
}