package com.redvelvet.ui.screen.loginScreen


sealed class LoginUIEvent {
    object LoginEvent: LoginUIEvent()
    object GuestEvent: LoginUIEvent()
}