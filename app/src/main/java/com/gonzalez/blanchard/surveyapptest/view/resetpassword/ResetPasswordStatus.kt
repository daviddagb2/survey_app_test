package com.gonzalez.blanchard.surveyapptest.view.resetpassword

sealed class ResetPasswordStatus {
    object Error : ResetPasswordStatus()
    object IsLoading : ResetPasswordStatus()
}
