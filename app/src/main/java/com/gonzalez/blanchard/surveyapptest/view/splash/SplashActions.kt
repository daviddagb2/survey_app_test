package com.gonzalez.blanchard.surveyapptest.view.splash

sealed class SplashActions {
    object GoToLogin : SplashActions()
    object GoToMain : SplashActions()
}
