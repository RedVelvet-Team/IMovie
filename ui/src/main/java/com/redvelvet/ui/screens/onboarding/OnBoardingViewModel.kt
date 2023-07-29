package com.redvelvet.ui.screens.onboarding

import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.user.SetUserNotFirstTimeUseAppUseCase
import com.redvelvet.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val setUserNotFirstTimeUseApp: SetUserNotFirstTimeUseAppUseCase,
) : BaseViewModel<OnBoardingUiState>(OnBoardingUiState()) {

    init {
        setNotFirstTimeUseApp()
    }

    private fun setNotFirstTimeUseApp() {
        viewModelScope.launch(Dispatchers.IO) {
            setUserNotFirstTimeUseApp.invoke()
        }
    }

}