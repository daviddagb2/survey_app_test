package com.gonzalez.blanchard.domain.models.surveyresponses

data class SurveyResponseRequestBO(
    val surveyId: String,
    val questions: List<QuestionDataBO>,
)
