package com.redvelvet.viewmodel.actor_details

import com.redvelvet.entities.actor.Actor
import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.usecase.usecase.GetActorDetailsUseCase
import com.redvelvet.usecase.usecase.GetActorKnownForUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(
    private val getActorDetails: GetActorDetailsUseCase,
    private val getActorKnownFor: GetActorKnownForUseCase
): BaseViewModel<ActorDetailsUiState, ActorDetailsUiEffect>(ActorDetailsUiState()) {
    
    private val args = 520
    init {
        getDetails()
        getActorKnownFor()
    }

    private fun getActorKnownFor() {
        tryToExecute(
            execute = {getActorKnownFor(args, 10)},
            onSuccessWithData = ::onGetActorKnownFor,
            onError = ::onError
        )
    }

    private fun getDetails(){
        tryToExecute(
            execute = {getActorDetails(args)},
            onSuccessWithData = ::onGetSuccess,
            onError = ::onError
        )
    }

    private fun onGetActorKnownFor(result: List<CombinedResult>){
        _state.update { it.copy(knownFor = result.map { it.toKnownForUiState() }) }
    }
    
    private fun onGetSuccess(result: Actor){
        _state.update { it.copy(
            isLoading = false,
            id = result.id,
            name = result.name,
            knownForDepartment = result.knownForDepartment,
            birthDate = result.birthday,
            birthLocation = result.placeOfBirth,
            imageUrl = "https://api.themoviedb.org/3" + result.profileImageUrl,
            knownAs = result.alsoKnownAs,
            biography = result.biography
        ) }
    }
    
    private fun onError(error: ErrorUiState){
        _state.update { it.copy(isLoading = false, error = error) }
    }
}