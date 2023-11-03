package com.gonzalez.blanchard.remotedatasource.models.surveydetail

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SurveyDetailDataDto(
    @Json(name = "id") val id: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "attributes") val attributes: SurveyDetailAttributeDto?,
    @Json(name = "relationships") val relationships: RelationshipDto?,
)
