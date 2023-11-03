package com.gonzalez.blanchard.remotedatasource.models.surveydetail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RelationshipDto(
    @Json(name = "questions") val questions: QuestionDto?,
)
