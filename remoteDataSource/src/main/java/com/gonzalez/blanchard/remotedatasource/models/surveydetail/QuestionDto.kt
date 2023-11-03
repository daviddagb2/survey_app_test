package com.gonzalez.blanchard.remotedatasource.models.surveydetail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class QuestionDto(
    @Json(name = "data") val data: List<QuestionDetailDto>?,
)
