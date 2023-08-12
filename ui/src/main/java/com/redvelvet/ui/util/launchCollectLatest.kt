package com.redvelvet.ui.util

import com.redvelvet.viewmodel.base.BaseUiEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun CoroutineScope.launchCollectLatest(
    sharedFlow: SharedFlow<BaseUiEffect>,
    block: suspend CoroutineScope.(event: BaseUiEffect) -> Unit
) {
    launch {
        sharedFlow.collectLatest { event -> block(event) }
    }
}