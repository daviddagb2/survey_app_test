package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.QuestionBO
import com.gonzalez.blanchard.domain.models.surveydetail.RelationshipBO
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailAttributeBO
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailDataBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.SurveyDetailDataDto

fun SurveyDetailDataDto.toSurveyDetailBO(): SurveyDetailDataBO = SurveyDetailDataBO(
    id = this.id ?: "",
    type = this.type ?: "",
    attributes = this.attributes?.toSurveyDetailAttributeBO() ?: SurveyDetailAttributeBO(
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
    relationships = this.relationships?.toRelationshipBO() ?: RelationshipBO(
        questions = QuestionBO(
            data = emptyList(),
        ),
    ),
)
