package com.redvelvet.viewmodel.login


interface LoginInteraction {
    fun onClickLogin()
    fun onClickGuest()
    fun onClickSignUp()
    fun onUserNameChanged(userName: String)
    fun onPasswordChanged(password: String)
}