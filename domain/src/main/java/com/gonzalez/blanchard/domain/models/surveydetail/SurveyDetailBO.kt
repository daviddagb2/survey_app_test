package com.gonzalez.blanchard.domain.models.surveydetail

data class SurveyDetailBO(
    val data: SurveyDetailDataBO,
    val included: List<QueryItemBO>,
)
