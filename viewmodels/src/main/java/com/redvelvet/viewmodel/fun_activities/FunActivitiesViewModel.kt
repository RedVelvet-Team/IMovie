package com.redvelvet.viewmodel.fun_activities

import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FunActivitiesViewModel @Inject constructor():
    BaseViewModel<FunActivitiesUiState, FunActivitiesUiEffect>(FunActivitiesUiState()) {
}