package com.redvelvet.viewmodel.actor_details

import com.redvelvet.entities.actor.Actor
import com.redvelvet.usecase.usecase.GetActorDetailsUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(
    private val getActorDetails: GetActorDetailsUseCase
): BaseViewModel<ActorDetailsUiState, ActorDetailsUiEffect>(ActorDetailsUiState()) {
    
    private val args = 520
    init {
        getDetails()
    }
    
    private fun getDetails(){
        tryToExecute(
            execute = {getActorDetails(args)},
            onSuccessWithData = ::onGetSuccess,
            onError = ::onError
        )
    }
    
    private fun onGetSuccess(result: Actor){
        _state.update { it.copy(
            isLoading = false,
            id = result.id,
            name = result.name,
            knownForDepartment = result.knownForDepartment,
            birthDate = result.birthday,
            birthLocation = result.placeOfBirth,
            imageUrl = result.profileImageUrl,
            knownAs = result.alsoKnownAs,
            biography = result.biography
        ) }
    }
    
    private fun onError(error: ErrorUiState){
        _state.update { it.copy(isLoading = false, error = error) }
    }
}