package com.gonzalez.blanchard.data.mappers.bo

import com.gonzalez.blanchard.domain.models.surveyresponses.AnswerDataBO
import com.gonzalez.blanchard.domain.models.surveyresponses.SurveyResponseRequestBO
import com.gonzalez.blanchard.remotedatasource.models.surveyresponses.AnswerDataDto
import com.gonzalez.blanchard.remotedatasource.models.surveyresponses.SurveyResponseRequestDto

fun SurveyResponseRequestBO.toSurveyResponseRequestDto(): SurveyResponseRequestDto =
    SurveyResponseRequestDto(
        surveyId = this.surveyId,
        questions = this.questions?.toAnswerDataDtoList(),
    )

fun List<AnswerDataBO>?.toAnswerDataDtoList(): List<AnswerDataDto>? =
    this?.map { it.toAnswerDataDto() }
