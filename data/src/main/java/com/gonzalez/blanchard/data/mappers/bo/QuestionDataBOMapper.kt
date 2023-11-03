package com.gonzalez.blanchard.data.mappers.bo

import com.gonzalez.blanchard.domain.models.surveyresponses.QuestionDataBO
import com.gonzalez.blanchard.remotedatasource.models.surveyresponses.QuestionDataDto

fun QuestionDataBO.toQuestionDataDto(): QuestionDataDto = QuestionDataDto(
    id = this.id,
    answers = this.answers?.toAnswerDataDtoList(),
)

fun List<QuestionDataBO>?.toAnswerDataDtoList(): List<QuestionDataDto>? =
    this?.map { it.toQuestionDataDto() }
