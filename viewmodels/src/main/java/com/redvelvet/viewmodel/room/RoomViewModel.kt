package com.redvelvet.viewmodel.room

import com.redvelvet.viewmodel.base.BaseUiEffect
import com.redvelvet.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(

) : BaseViewModel<RoomUiState, BaseUiEffect>(RoomUiState()) {
}