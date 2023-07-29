package com.redvelvet.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<UiState : BaseUiState>(state: UiState) : ViewModel() {

    private val _state = MutableStateFlow(state)
    protected val state = _state.asStateFlow()

//    fun <T> tryToExecute(
//        function: suspend () -> T,
//        onSuccess: (T) -> Unit,
//        onError: (code: BaseErrorUiState) -> Unit,
//        dispatcher: CoroutineDispatcher = Dispatchers.IO
//    ) {
//        viewModelScope.launch(dispatcher) {
//            try {
//                val result = function()
//                onSuccess(result)
//            } catch (e: ErrorType.Network) {
//                onError(BaseErrorUiState.Disconnected(e.message.toString()))
//            }catch (e: ErrorType.NoData) {
//                onError(BaseErrorUiState.NoData(e.message.toString()))
//            }catch (error: Throwable) {
//                onError(BaseErrorUiState.NoFoundError(error.message.toString()))
//            }
//        }
//
//    }
}

interface BaseUiState {

}
