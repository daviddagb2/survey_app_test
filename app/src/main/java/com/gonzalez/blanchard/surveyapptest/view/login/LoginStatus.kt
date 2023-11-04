package com.gonzalez.blanchard.surveyapptest.view.login

sealed class LoginStatus {
    object ErrorLogin : LoginStatus()
    object IsLoading : LoginStatus()
}
