package com.redvelvet.viewmodel.login


interface LoginInteraction {
    fun onUserNameChanged(userName: String)
    fun onPasswordChanged(password: String)
}