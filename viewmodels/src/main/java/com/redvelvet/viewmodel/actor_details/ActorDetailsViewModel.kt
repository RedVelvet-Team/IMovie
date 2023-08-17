package com.redvelvet.viewmodel.actor_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.actor.Actor
import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.usecase.usecase.GetActorDetailsUseCase
import com.redvelvet.usecase.usecase.GetActorKnownForUseCase
import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ActorDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getActorDetails: GetActorDetailsUseCase,
    private val getActorKnownFor: GetActorKnownForUseCase
): BaseViewModel<ActorDetailsUiState, BaseUiEffect>(ActorDetailsUiState()) {
    
    private val args: ActorDetailsArgs = ActorDetailsArgs(savedStateHandle)
    init {
        getDetails()
        getActorKnownFor()
    }

    private fun getActorKnownFor() {
        tryToExecute(
            execute = {getActorKnownFor(args.id, 10)},
            onSuccessWithData = ::onGetActorKnownFor,
            onError = ::onError
        )
    }

    private fun getDetails(){
        tryToExecute(
            execute = {getActorDetails(args.id)},
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
            id = result.id.toString(),
            name = result.name,
            knownForDepartment = result.knownForDepartment,
            birthDate = result.birthday,
            birthLocation = result.placeOfBirth,
            imageUrl =  "https://image.tmdb.org/t/p/w500" + result.profileImageUrl,
            knownAs = result.alsoKnownAs,
            biography = result.biography
        ) }
    }
    
    private fun onError(error: ErrorUiState){
        Log.v("hass", error.toString())
        _state.update { it.copy(isLoading = false, error = error) }
    }
}