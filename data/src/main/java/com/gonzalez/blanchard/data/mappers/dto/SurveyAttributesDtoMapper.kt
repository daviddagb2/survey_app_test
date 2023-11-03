package com.gonzalez.blanchard.data.mappers.dto

import com.gonzalez.blanchard.domain.models.surveylist.SurveyAttributesBO
import com.gonzalez.blanchard.remotedatasource.models.surveylist.SurveyAttributesDto

fun SurveyAttributesDto.toSurveyAttributesBO(): SurveyAttributesBO = SurveyAttributesBO(
    title = this.title ?: "",
    description = this.description ?: "",
    thankEmailAboveThreshold = this.thankEmailAboveThreshold ?: "",
    thankEmailBelowThreshold = this.thankEmailBelowThreshold ?: "",
    isActive = this.isActive ?: false,
    coverImageUrl = this.coverImageUrl ?: "",
    createdAt = this.createdAt ?: "",
    activeAt = this.activeAt ?: "",
    inactiveAt = this.inactiveAt ?: "",
    surveyType = this.surveyType ?: "",
)
