package com.redvelvet.viewmodel.onboarding

import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.user.SetUserNotFirstTimeUseAppUseCase
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val setUserNotFirstTimeUseApp: SetUserNotFirstTimeUseAppUseCase,
    ) : BaseViewModel<OnBoardingUiState, OnBoardingUiEvent>(OnBoardingUiState()),
    OnBoardingInteractions {
    fun setNotFirstTimeUseApp() {
        viewModelScope.launch(Dispatchers.IO) {
            setUserNotFirstTimeUseApp.invoke()
            _state.update {
                it.copy(
                    saved = true,
                )
            }
            sendUiEvent(OnBoardingUiEvent.NavigateToLogin)
        }
    }

    //region sign in
    private fun signIn() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEvent(OnBoardingUiEvent.NavigateToLogin)
    }
    //endregion

    //region signup
    private fun signUp() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
        sendUiEvent(OnBoardingUiEvent.NavigateToSignUpScreen)
    }
    //endregion

    //region interaction
    override fun onClickLogin() {
        signIn()
    }
    override fun onClickSignUp() {
        signUp()
    }
    //endregion

}