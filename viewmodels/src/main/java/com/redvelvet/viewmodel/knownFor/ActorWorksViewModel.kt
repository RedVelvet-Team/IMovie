package com.redvelvet.viewmodel.knownFor

import androidx.lifecycle.SavedStateHandle
import com.redvelvet.entities.search.CombinedResult
import com.redvelvet.usecase.usecase.GetActorKnownForUseCase
import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ActorWorksViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getActorKnownFor: GetActorKnownForUseCase
): BaseViewModel<ActorWorksUiState, BaseUiEffect>(ActorWorksUiState()) {
    
    private val args: KnownForArgs = KnownForArgs(savedStateHandle)
    init {
        getActorKnownFor()
    }

    private fun getActorKnownFor() {
        tryToExecute(
            execute = {getActorKnownFor(args.id)},
            onSuccessWithData = ::onGetActorKnownFor,
            onError = ::onError
        )
    }


    private fun onGetActorKnownFor(result: List<CombinedResult>){
        _state.update { it.copy(
            isLoading = false,
            knownFor = result.map { it.toKnownForUiState() }
        ) }
    }
    
    private fun onError(error: ErrorUiState){
        _state.update { it.copy(isLoading = false, error = error) }
    }
}