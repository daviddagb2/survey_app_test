package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailAttributeBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.SurveyDetailAttributeDto

fun SurveyDetailAttributeDto.toSurveyDetailAttributeBO(): SurveyDetailAttributeBO = SurveyDetailAttributeBO(
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
