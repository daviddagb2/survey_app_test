package com.gonzalez.blanchard.data.mappers.dto

import com.gonzalez.blanchard.domain.models.surveylist.MetaBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyResponseBO
import com.gonzalez.blanchard.remotedatasource.models.surveylist.SurveyDto
import com.gonzalez.blanchard.remotedatasource.models.surveylist.SurveyResponseDto

fun SurveyResponseDto.toSurveyResponseBO(): SurveyResponseBO = SurveyResponseBO(
    surveys = this.surveys.toSurveyBOList(),
    metadata = this.metadata?.toMetaBO() ?: MetaBO(0, 0, 0, 0),
)

fun List<SurveyDto>?.toSurveyBOList(): List<SurveyBO> =
    this?.map { it.toSurveyBO() } ?: run { listOf() }
