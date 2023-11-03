package com.gonzalez.blanchard.domain.models.surveydetail

data class SurveyDetailAttributeBO(
    val title: String,
    val description: String,
    val thankEmailAboveThreshold: String,
    val thankEmailBelowThreshold: String,
    val isActive: Boolean,
    val coverImageUrl: String,
    val createdAt: String,
    val activeAt: String,
    val inactiveAt: String,
    val surveyType: String,
)
