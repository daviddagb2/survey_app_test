package com.gonzalez.blanchard.remotedatasource.models.surveydetail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyDetailDto(
    @Json(name = "data") val data: SurveyDetailDataDto?,
    @Json(name = "included") val included: List<IncludedDto>?,
)
