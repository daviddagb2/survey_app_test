package com.gonzalez.blanchard.surveyapptest.view.main

import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyResponseBO

sealed class MainActivityActions {
    object StopLoading : MainActivityActions()
    class GoToSurveyDetail(val survey: SurveyBO) : MainActivityActions()
    class ShowSurveys(val response: SurveyResponseBO) : MainActivityActions()
}
