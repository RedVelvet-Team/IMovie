package com.redvelvet.viewmodel.onboarding

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.redvelvet.usecase.usecase.user.CreateRequestTokenUseCase
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
    private val createRequestTokenUseCase: CreateRequestTokenUseCase,
) : BaseViewModel<OnBoardingUiState>(OnBoardingUiState()) {

    init {
        createRequestToken()
    }

    private fun createRequestToken() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = createRequestTokenUseCase()
                Log.i("KAMELOO", "createRequestToken: ${token.toString()}")
            } catch (e: Exception) {
                Log.i("KAMELOO", "createRequestToken: ${e.message.toString()}")
            }
        }
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