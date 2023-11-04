package com.gonzalez.blanchard.surveyapptest.view.survey.carousel

import com.gonzalez.blanchard.domain.models.surveydetail.QueryItemBO

sealed class SurveyQuestion {
    data class StartSurveyQuestion(val queryItem: QueryItemBO) : SurveyQuestion()
    data class TextQuestion(val queryItem: QueryItemBO) : SurveyQuestion()
    data class MultipleChoiceQuestion(val queryItem: QueryItemBO) : SurveyQuestion()
    data class YesNoQuestion(val queryItem: QueryItemBO) : SurveyQuestion()
}
