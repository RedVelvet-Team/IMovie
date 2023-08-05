package com.redvelvet.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.redvelvet.entities.error.ErrorType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KFunction0

abstract class BaseViewModel<UiState : BaseUiState>(state: UiState) : ViewModel() {

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    fun <T> tryToExecute(
        function: suspend () -> T,
        onSuccess:(T)-> Unit,
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = function()
                onSuccess(result)
            } catch (e: ErrorType) {
                onError(e.toErrorUiState())
            }
        }
    }

    fun <T : Any> tryToExecutePaging(
        call: suspend () -> Flow<PagingData<List<T>>>,
        onSuccess: suspend (PagingData<List<T>>) -> Unit,
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = call()
                delay(1000)
                launch(Dispatchers.Main) {
                    result.collect { data ->
                        onSuccess(data)
                    }
                }
            } catch (e: ErrorType) {
                onError(e.toErrorUiState())
            }
        }
    }

}

interface BaseUiState
