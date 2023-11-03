package com.gonzalez.blanchard.remotedatasource.models.surveyresponses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnswerDataDto(
    @Json(name = "id") val id: String?,
    @Json(name = "answer") val answer: String?,
)
