package com.redvelvet.ui

sealed class MovieDestination(val route: String) {
    object Home: MovieDestination("home")
    object Boarding: MovieDestination("boarding")
    object LogIn: MovieDestination("login")
}