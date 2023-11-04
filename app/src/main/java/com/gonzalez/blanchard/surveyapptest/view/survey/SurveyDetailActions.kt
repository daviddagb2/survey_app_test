package com.gonzalez.blanchard.surveyapptest.view.survey

import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailBO

sealed class SurveyDetailActions {
    object StopLoading : SurveyDetailActions()
    object ShowExitWarning : SurveyDetailActions()
    class ShowSurveysDetail(val response: SurveyDetailBO) : SurveyDetailActions()
}
