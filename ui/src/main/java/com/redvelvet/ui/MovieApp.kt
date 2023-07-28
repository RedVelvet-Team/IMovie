package com.redvelvet.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            MovieNavGraph(navController)
        }
    }
}