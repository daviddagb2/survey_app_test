package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.QuestionBO
import com.gonzalez.blanchard.domain.models.surveydetail.RelationshipBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.RelationshipDto

fun RelationshipDto.toRelationshipBO(): RelationshipBO = RelationshipBO(
    questions = this.questions?.toQuestionBO() ?: QuestionBO(
        data = this.questions?.data?.map { it.toQuestionDetailBO() } ?: listOf(),
    )
)