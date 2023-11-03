package com.gonzalez.blanchard.remotedatasource.models.surveyresponses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyResponseRequestDto(
    @Json(name = "survey_id") val surveyId: String?,
    @Json(name = "questions") val questions: List<QuestionDataDto>?,
)
