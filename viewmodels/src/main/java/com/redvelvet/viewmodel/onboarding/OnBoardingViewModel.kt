package com.redvelvet.viewmodel.onboarding

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

    private fun onCheckedSuccess(checkedLoggedIn: Boolean) {
        if (checkedLoggedIn) {
            getAccountDetails::invoke
            _state.update {
                it.copy(
                    loggedIn = true,
                    error = null,
                )
            }
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