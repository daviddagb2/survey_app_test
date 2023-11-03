package com.gonzalez.blanchard.domain.models.surveydetail

data class SurveyDetailDataBO(
    val id: String,
    val type: String,
    val attributes: SurveyDetailAttributeBO,
    val relationships: RelationshipBO,
)
