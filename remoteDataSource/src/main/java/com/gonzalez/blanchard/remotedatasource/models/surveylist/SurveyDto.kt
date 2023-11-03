package com.gonzalez.blanchard.remotedatasource.models.surveylist

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyDto(
    @Json(name = "id") val id: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "attributes") val attributes: SurveyAttributesDto?,
)
