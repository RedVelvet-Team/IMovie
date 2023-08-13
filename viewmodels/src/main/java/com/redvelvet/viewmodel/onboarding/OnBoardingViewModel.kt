package com.redvelvet.viewmodel.onboarding

import com.redvelvet.usecase.usecase.user.CheckUserLoggedInUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import com.redvelvet.viewmodel.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val checkUserLoggedInUseCase: CheckUserLoggedInUseCase,
) : BaseViewModel<OnBoardingUiState, OnBoardingUiEffect>(OnBoardingUiState()),
    OnBoardingInteractions {
    init {
        checkUserIsLoggedIn()
    }

    //region check user loggedin
    private fun checkUserIsLoggedIn() {
        tryToExecute(
            execute = checkUserLoggedInUseCase::invoke,
            onSuccess = ::onCheckedSuccess,
            onError = ::onCheckedError,
        )
    }

    private fun onCheckedSuccess(checkedLoggedIn: Boolean) {
        if (checkedLoggedIn) {
            sendUiEffect(OnBoardingUiEffect.NavigateToHomeScreen)
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

    //region interaction
    override fun onClickLogin() {
        sendUiEffect(OnBoardingUiEffect.NavigateToLoginScreen)
    }

    override fun onClickSignUp() {
        sendUiEffect(OnBoardingUiEffect.NavigateToSignUpScreen)
    }
    //endregion

}