package com.gonzalez.blanchard.surveyapptest.view.main

import com.gonzalez.blanchard.domain.models.UserBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyResponseBO

sealed class MainActivityActions {
    object StopLoading : MainActivityActions()
    object Logout : MainActivityActions()
    class GoToSurveyDetail(val survey: SurveyBO) : MainActivityActions()
    class ShowSurveys(val response: SurveyResponseBO) : MainActivityActions()
    class LoadUserData(val userBO: UserBO) : MainActivityActions()
}
