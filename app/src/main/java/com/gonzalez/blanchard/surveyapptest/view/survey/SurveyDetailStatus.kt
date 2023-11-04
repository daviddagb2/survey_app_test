package com.gonzalez.blanchard.surveyapptest.view.survey

sealed class SurveyDetailStatus {
    object Error : SurveyDetailStatus()
    object IsLoading : SurveyDetailStatus()
}
