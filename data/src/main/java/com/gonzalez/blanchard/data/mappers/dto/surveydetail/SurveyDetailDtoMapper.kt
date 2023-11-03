package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.QuestionBO
import com.gonzalez.blanchard.domain.models.surveydetail.RelationshipBO
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailAttributeBO
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailBO
import com.gonzalez.blanchard.domain.models.surveydetail.SurveyDetailDataBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyAttributesBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyBO
import com.gonzalez.blanchard.domain.models.surveylist.SurveyResponseBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.SurveyDetailDto
import com.gonzalez.blanchard.remotedatasource.models.surveylist.SurveyDto


fun SurveyDetailDto.toSurveyDetailBO(): SurveyDetailBO = SurveyDetailBO(
    data = this.data?.toSurveyDetailBO() ?: SurveyDetailDataBO(
        id = "",
        type = "",
        attributes = SurveyDetailAttributeBO(
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
        relationships = RelationshipBO(
            questions = QuestionBO(
                data = emptyList(),
            ),
        ),
    ),
    included = this.included.toSurveyBOList(),
)
