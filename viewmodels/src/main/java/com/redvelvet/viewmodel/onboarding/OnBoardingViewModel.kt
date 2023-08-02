package com.redvelvet.viewmodel.onboarding

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.auth.CreateGuestSessionUseCase
import com.redvelvet.usecase.usecase.auth.ValidateUserWithLoginUseCase
import com.redvelvet.usecase.usecase.user.SetUserNotFirstTimeUseAppUseCaseImpl
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val setUserNotFirstTimeUseApp: SetUserNotFirstTimeUseAppUseCaseImpl,
    private val createGuestSessionUseCase: CreateGuestSessionUseCase,
    private val validateUserWithLoginUseCase: ValidateUserWithLoginUseCase,
) : BaseViewModel<OnBoardingUiState>(OnBoardingUiState()) {

    init {
//        createGuestSession()
        validate()
    }

    private fun validate() {
        tryToExecute(
            function = {
                validateUserWithLoginUseCase(
                    userName = "Kamel_ElSayed",
                    password = "23820018Ka",
                )
            },
            onSuccess = { Log.i("KAMELOO", it.toString()) },
            onError = { Log.i("KAMELOO", it.toString()) },
        )
    }

    private fun createGuestSession() {
        tryToExecute(
            function = { createGuestSessionUseCase() },
            onSuccess = { Log.i("KAMELOO", it.toString()) },
            onError = { Log.i("KAMELOO", it.toString()) },
        )
    }

    fun setNotFirstTimeUseApp() {
        viewModelScope.launch(Dispatchers.IO) {
            setUserNotFirstTimeUseApp.invoke(false)
            _state.update {
                it.copy(
                    saved = true,
                )
            }
        }
    }

}