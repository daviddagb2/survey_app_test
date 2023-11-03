package com.gonzalez.blanchard.remotedatasource.models.surveyresponses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuestionDataDto(
    @Json(name = "id") val id: String?,
    @Json(name = "answers") val answers: List<AnswerDataDto>?,
)
