package com.gonzalez.blanchard.remotedatasource.models.surveylist

import com.gonzalez.blanchard.remotedatasource.models.MetaDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyResponseDto(
    @Json(name = "data") val surveys: List<SurveyDto>?,
    @Json(name = "meta") val metadata: MetaDto?,
)
