package com.redvelvet.viewmodel.onboarding

import android.util.Log
import com.redvelvet.usecase.usecase.auth.GetAccountDetailsUsecase
import com.redvelvet.usecase.usecase.user.CheckUserLoggedInUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val checkUserLoggedInUseCase: CheckUserLoggedInUseCase,
    private val getAccountDetails: GetAccountDetailsUsecase,
) : BaseViewModel<OnBoardingUiState, Unit>(OnBoardingUiState()) {

    init {
        checkUserIsLoggedIn()
    }

    //region check user loggedIn
    private fun checkUserIsLoggedIn() {
        tryToExecute(
            execute = checkUserLoggedInUseCase::invoke,
            onSuccessWithData = ::onCheckedSuccess,
            onError = ::onCheckedError,
        )
    }

    private fun onCheckAccountDetailsIsSaved(isUserDetailsSaved: Boolean) {
        Log.e("hass", "isUserDetailsSaved$isUserDetailsSaved")
    }

    private fun onCheckAccountDetailsNotSaved(error: ErrorUiState) {
        Log.e("hass", "error${error.message}")
    }

    private fun onCheckedSuccess(checkedLoggedIn: Boolean) {
        if (checkedLoggedIn) {
            _state.update {
                it.copy(
                    loggedIn = true,
                    error = null,
                )
            }
            tryToExecute(
                execute = getAccountDetails::invoke,
                onSuccessWithData = ::onCheckAccountDetailsIsSaved,
                onError = ::onCheckAccountDetailsNotSaved,
            )
        }
    }

    private fun onCheckedError(error: ErrorUiState) {
        _state.update {
            it.copy(
                loggedIn = false,
                error = error,
            )
        }
    }
    //endregion
}