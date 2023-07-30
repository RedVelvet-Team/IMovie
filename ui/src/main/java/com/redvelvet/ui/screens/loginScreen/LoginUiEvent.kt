package com.redvelvet.ui.screens.loginScreen


sealed class LoginUIEvent {
    object LoginEvent: LoginUIEvent()
    object GuestEvent: LoginUIEvent()
}