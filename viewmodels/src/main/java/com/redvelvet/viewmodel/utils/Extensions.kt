package com.redvelvet.viewmodel.utils

import com.redvelvet.viewmodel.base.BaseUiEffect
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

fun CoroutineScope.launchCollectLatest(
    flow: Flow<BaseUiEffect>,
    block: suspend CoroutineScope.(event: BaseUiEffect) -> Unit
) {
    launch {
        flow.collectLatest { event -> block(event) }
    }
}