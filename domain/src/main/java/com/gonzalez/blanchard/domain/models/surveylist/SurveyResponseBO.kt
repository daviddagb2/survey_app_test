package com.gonzalez.blanchard.domain.models.surveylist

data class SurveyResponseBO(
    val surveys: List<SurveyBO>,
    val metadata: MetaBO,
)
