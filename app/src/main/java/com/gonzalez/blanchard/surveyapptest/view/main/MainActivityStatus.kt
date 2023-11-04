package com.gonzalez.blanchard.surveyapptest.view.main

sealed class MainActivityStatus {
    object Error : MainActivityStatus()
    object IsLoading : MainActivityStatus()
}
