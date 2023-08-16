package com.redvelvet.ui.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.redvelvet.ui.LocalNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun <T> NavigationHandler(
    effects: Flow<T>,
    handleEffect: (T, NavController) -> Unit
) {
    val navController = LocalNavController.current
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = effects) {
        scope.launch {
            effects.collectLatest { effect ->
                handleEffect(effect, navController)
            }
        }
    }
}