package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.IncludedAttributesBO
import com.gonzalez.blanchard.domain.models.surveydetail.IncludedBO
import com.gonzalez.blanchard.domain.models.surveydetail.QuestionBO
import com.gonzalez.blanchard.domain.models.surveydetail.RelationshipBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.IncludedDto

fun IncludedDto.toIncludedBO(): IncludedBO = IncludedBO(
    id = this.id ?: "",
    type = this.type ?: "",
    attributes = this.attributes?.toIncludedAttributesBO() ?: IncludedAttributesBO(
        text = "",
        helpText = "",
        displayOrder = 0,
        shortText = "",
        pick = "",
        displayType = "",
        isMandatory = false,
        correctAnswerId = "",
        facebookProfile = "",
        twitterProfile = "",
        imageUrl = "",
        coverImageUrl = "",
        coverImageOpacity = 0.0,
        coverBackgroundColor = "",
        isShareableOnFacebook = false,
        isShareableOnTwitter = false,
        fontFace = "",
        fontSize = "",
        tagList = "",
    ),
    relationships = this.relationships?.toRelationshipBO() ?: RelationshipBO(
        questions = QuestionBO(
            data = emptyList(),
        ),
    ),
)

fun List<IncludedDto>?.toSurveyBOList(): List<IncludedBO> =
    this?.map { it.toIncludedBO() } ?: run { listOf() }
