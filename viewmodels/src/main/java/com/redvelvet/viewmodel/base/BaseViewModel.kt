package com.redvelvet.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.redvelvet.entities.error.MovieError
import com.redvelvet.entities.error.NetworkError
import com.redvelvet.entities.error.NullResultError
import com.redvelvet.entities.error.ValidationError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState : BaseUiState, UiEvent>(state: UiState) :
    ViewModel() {

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    private val _effect = MutableSharedFlow<UiEffect>()
    val effect = _effect.asSharedFlow()

    fun <T> tryToExecute(
        execute: suspend () -> T,
        onSuccessWithData: (T) -> Unit = {},
        onSuccessWithoutData: () -> Unit = {},
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = execute()
                onSuccessWithData(result)
                onSuccessWithoutData()
            } catch (e: ValidationError) {
                onError(InvalidationErrorState())
            } catch (e: NullResultError) {
                onError(NullResultErrorState())
            } catch (e: NetworkError) {
                onError(NetworkErrorState())
            } catch (e: MovieError) {
                onError(ErrorUiState())
            }
        }
    }

    fun <T : Any> tryToExecutePaging(
        call: suspend () -> Flow<PagingData<T>>,
        onSuccess: suspend (PagingData<T>) -> Unit,
        onError: (error: ErrorUiState) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ) {
        viewModelScope.launch(dispatcher) {
            try {
                val result = call()
                result.collect { data ->
                    onSuccess(data)
                }
            } catch (e: NullResultError) {
                onError(NullResultErrorState())
            } catch (e: NetworkError) {
                onError(NetworkErrorState())
            } catch (e: MovieError) {
                onError(ErrorUiState())
            }
        }
    }

    protected fun sendUiEffect(uiEffect: UiEffect) {
        viewModelScope.launch(Dispatchers.IO) {
            _effect.emit(uiEffect)
        }
    }
}

interface BaseUiState

interface BaseUiEffect
