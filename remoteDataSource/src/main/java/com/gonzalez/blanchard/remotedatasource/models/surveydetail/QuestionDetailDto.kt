package com.gonzalez.blanchard.remotedatasource.models.surveydetail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuestionDetailDto(
    @Json(name = "id") val id: String?,
    @Json(name = "type") val type: String?,
)
