package com.gonzalez.blanchard.data.mappers.dto.surveydetail

import com.gonzalez.blanchard.domain.models.surveydetail.QuestionBO
import com.gonzalez.blanchard.domain.models.surveydetail.QuestionDetailBO
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.QuestionDetailDto
import com.gonzalez.blanchard.remotedatasource.models.surveydetail.QuestionDto

fun QuestionDto.toQuestionBO(): QuestionBO = QuestionBO(
    data = this.data?.toQuestionDetailBOList() ?: emptyList(),
)

fun List<QuestionDetailDto>?.toQuestionDetailBOList(): List<QuestionDetailBO> =
    this?.map { it.toQuestionDetailBO() } ?: run { listOf() }
