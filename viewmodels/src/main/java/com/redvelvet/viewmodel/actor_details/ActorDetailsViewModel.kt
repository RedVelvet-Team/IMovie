package com.redvelvet.viewmodel.actor_details

import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(

): BaseViewModel<ActorDetailsUiState, ActorDetailsUiEffect>(ActorDetailsUiState()) {

}