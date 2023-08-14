package com.redvelvet.viewmodel.login

interface LoginInteraction {
    fun onUserNameChanged(userName: String)
    fun onPasswordChanged(password: String)
    fun onClickLogin()
    fun onClickGuest()
    fun onClickEyeIcon()
    fun onClickForgotPassword()
}