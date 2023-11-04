package com.gonzalez.blanchard.surveyapptest.view.login

sealed class LoginActions {
    object GoToMain : LoginActions()
    object StopLoading : LoginActions()
    class ChangeLang(val langCode: String) : LoginActions()
}
