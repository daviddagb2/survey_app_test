package com.gonzalez.blanchard.data.mappers.dto

import com.gonzalez.blanchard.domain.models.surveylist.SurveyAttributesBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.remotedatasource.models.surveylist.SurveyDto

fun SurveyDto.toSurveyBO(): SurveyBO = SurveyBO(
    id = this.id ?: "",
    type = this.type ?: "",
    attributes = this.attributes?.toSurveyAttributesBO() ?: SurveyAttributesBO(
        title = "",
        description = "",
        thankEmailAboveThreshold = "",
        thankEmailBelowThreshold = "",
        isActive = false,
        coverImageUrl = "",
        createdAt = "",
        activeAt = "",
        inactiveAt = "",
        surveyType = "",
    ),
)
