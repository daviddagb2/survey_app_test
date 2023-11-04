package com.gonzalez.blanchard.surveyapptest.view.login

sealed class LoginActions {
    object GoToMain : LoginActions()
    object GoToForgotPassword : LoginActions()
    object StopLoading : LoginActions()
}
