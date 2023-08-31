package com.redvelvet.viewmodel.library


import android.util.Log
import com.redvelvet.entities.library.LibraryDetails
import com.redvelvet.usecase.usecase.libraryList.ClearListUseCase
import com.redvelvet.usecase.usecase.libraryList.CreateListUseCase
import com.redvelvet.usecase.usecase.libraryList.DeleteListUseCase
import com.redvelvet.usecase.usecase.libraryList.GetLibraryDataUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val getLibraryDataUseCase: GetLibraryDataUseCase,
    private val createListUseCase: CreateListUseCase,
    private val clearListUseCase: ClearListUseCase,
    private val deleteListUseCase: DeleteListUseCase,
) : BaseViewModel<LibraryUiState, LibraryUiEffect>(LibraryUiState()), LibraryUiInteraction {

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            execute = { getLibraryDataUseCase.invoke() },
            onError = ::onError,
            onSuccessWithData = ::onSuccess
        )
    }

    private fun onSuccess(libraryDetails: LibraryDetails) {
        Log.i("abaferas", libraryDetails.toString())
        _state.update {
            LibraryUiState(
                data = libraryDetails.toUiState().data,
                isLoading = false,
                error = null,
            )
        }
    }

    private fun onError(error: ErrorUiState) {
        Log.i("abaferas", error.message)
        _state.update {
            it.copy(
                isLoading = false,
                error = error,
            )
        }
    }

    override fun onClickAddPlayList(name: String) {
        tryToExecute(
            execute = { createListUseCase.invoke(name) },
            onError = ::onError,
            onSuccessWithoutData = ::onActionDone,
        )
        refresh()
    }

    private fun refresh() {
        getData()
    }

    override fun onClickPlayList(listId: Int) {
        sendUiEffect(LibraryUiEffect.NavigateToList(listId))
    }

    override fun onClickFavItem(id: Int) {
        sendUiEffect(LibraryUiEffect.NavigateToMovie(id))
    }

    override fun onClearList(listId: Int) {
        tryToExecute(
            execute = { clearListUseCase.invoke(listId = listId) },
            onError = ::onDeleteError,
            onSuccessWithoutData = ::onActionDone
        )
    }

    override fun onClickLogin() {
        sendUiEffect(LibraryUiEffect.NavigateToLogin)
    }

    override fun onClickGotoLibrary() {
        sendUiEffect(LibraryUiEffect.NavigateToLibrary)
    }

    override fun onDeleteList(listId: Int) {
        tryToExecute(
            execute = { deleteListUseCase.invoke(listId = listId) },
            onError = ::onDeleteError,
            onSuccessWithoutData = ::onActionDone
        )
    }

    private fun onActionDone() {
        getData()
    }

    private fun onDeleteError(error: ErrorUiState) {
        getData()
    }


}