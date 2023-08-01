package com.redvelvet.viewmodel.splash

import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.user.CheckUserFirstTimeUseAppUseCaseImpl
import com.redvelvet.usecase.usecase.user.CheckUserIsGuestUseCaseImpl
import com.redvelvet.usecase.usecase.user.CheckUserLoggedInUseCaseImpl
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val checkUserFirstTimeUseAppUseCase: CheckUserFirstTimeUseAppUseCaseImpl,
    private val checkUserUserIsLoggedInUseCase: CheckUserLoggedInUseCaseImpl,
    private val checkUserIsGuestUseCase: CheckUserIsGuestUseCaseImpl
) : BaseViewModel<SplashUiState>(SplashUiState()) {

    init {
        getUserStatus()
    }

    private fun getUserStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            val isLogged = checkUserUserIsLoggedInUseCase()
            val isGuest = checkUserIsGuestUseCase()
            val isFirstTimeUseApp = checkUserFirstTimeUseAppUseCase()
            _state.update {
                it.copy(
                    isLogged = isLogged,
                    isGuest = isGuest,
                    isFirstTimeUseApp = isFirstTimeUseApp
                )
            }
        }
    }
}