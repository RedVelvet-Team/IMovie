package com.redvelvet.viewmodel.utils

import com.redvelvet.viewmodel.base.BaseUiEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun CoroutineScope.launchCollectLatest(
    flow: Flow<BaseUiEvent>,
    block: suspend CoroutineScope.(event: BaseUiEvent) -> Unit
) {
    launch {
        flow.collectLatest { event -> block(event) }
    }
}