package com.gonzalez.blanchard.surveyapptest.view.resetpassword

sealed class ResetPasswordActions {
    object GoToLogin : ResetPasswordActions()
    object StopLoading : ResetPasswordActions()

    class ShowAlert(val message: String) : ResetPasswordActions()
}
