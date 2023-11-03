package com.gonzalez.blanchard.domain.models.surveylist

data class SurveyBO(
    val id: String,
    val type: String,
    val attributes: SurveyAttributesBO,
)
