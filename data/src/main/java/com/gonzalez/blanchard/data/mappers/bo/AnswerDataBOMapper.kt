package com.gonzalez.blanchard.data.mappers.bo

import com.gonzalez.blanchard.domain.models.surveyresponses.AnswerDataBO
import com.gonzalez.blanchard.remotedatasource.models.surveyresponses.AnswerDataDto

fun AnswerDataBO.toAnswerDataDto(): AnswerDataDto = AnswerDataDto(
    id = this.id,
    answer = this.answer,
)
