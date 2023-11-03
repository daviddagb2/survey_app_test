package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.QuestionDetailBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.QuestionDetailDto

fun QuestionDetailDto.toQuestionDetailBO(): QuestionDetailBO = QuestionDetailBO(
    id = this.id ?: "",
    type = this.type ?: "",
)
